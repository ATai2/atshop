package com.atshop.order.controller;

import com.alibaba.fastjson.JSON;
import com.atshop.order.dto.SaveBean;
import com.atshop.order.entity.PmsSearchParam;
import com.atshop.order.entity.PmsSearchSkuInfo;
import com.atshop.order.utils.ElasticSearchUtil;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    JestClient jestClient;

    @Autowired
    private ElasticSearchUtil elasticSearchUtil;

    @GetMapping("list")
    public List<PmsSearchSkuInfo> list(PmsSearchParam pmsSearchParam) {
        String dslStr = getSearchDsl(pmsSearchParam);
        System.err.println(dslStr);
        // 用api执行复杂查询
        List<PmsSearchSkuInfo> pmsSearchSkuInfos = new ArrayList<>();
        Search search = new Search.Builder(dslStr).addIndex("gmall").addType("PmsSkuInfo").build();
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
            if (execute != null) {
                List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = execute.getHits(PmsSearchSkuInfo.class);
                for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
                    PmsSearchSkuInfo source = hit.source;
                    Map<String, List<String>> highlight = hit.highlight;
                    if (highlight != null) {
                        String skuName = highlight.get("skuName").get(0);
                        source.setSkuName(skuName);
                    }
                    pmsSearchSkuInfos.add(source);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pmsSearchSkuInfos;
    }

    private String getSearchDsl(PmsSearchParam pmsSearchParam) {
        String[] skuAttrValueList = pmsSearchParam.getValueId();
        String keyword = pmsSearchParam.getKeyword();
        String catalog3Id = pmsSearchParam.getCatalog3Id();
        // jest的dsl工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // filter
        if (StringUtils.isNotBlank(catalog3Id)) {
            TermQueryBuilder termQueryBuilder = new TermQueryBuilder("catalog3Id", catalog3Id);
            boolQueryBuilder.filter(termQueryBuilder);
        }
        if (skuAttrValueList != null) {
            for (String pmsSkuAttrValue : skuAttrValueList) {
                TermQueryBuilder termQueryBuilder = new TermQueryBuilder("skuAttrValueList.valueId", pmsSkuAttrValue);
                boolQueryBuilder.filter(termQueryBuilder);
            }
        }

        // must
        if (StringUtils.isNotBlank(keyword)) {
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("skuName", keyword);
            boolQueryBuilder.must(matchQueryBuilder);
        }

        // query
        searchSourceBuilder.query(boolQueryBuilder);

        // highlight
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color:red;'>");
        highlightBuilder.field("skuName");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);
        // sort
        searchSourceBuilder.sort("id", SortOrder.DESC);
        // from
        searchSourceBuilder.from(0);
        // size
        searchSourceBuilder.size(20);
        // aggs
        TermsAggregationBuilder groupby_attr = AggregationBuilders.terms("groupby_attr").field("skuAttrValueList.valueId");
        searchSourceBuilder.aggregation(groupby_attr);
        return searchSourceBuilder.toString();
    }

    @PostMapping("save")
    public String saveObject(@RequestBody SaveBean esSaveBean) {
        String dataJson = esSaveBean.getDataJson();
        Map map = JSON.parseObject(dataJson, Map.class);
        JestResult index = elasticSearchUtil.createIndex(map, esSaveBean.getIndex(), esSaveBean.getType(), esSaveBean.getId());
        return index.getJsonString();
    }
}
