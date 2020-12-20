package com.atshop.search.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atshop.search.SearchApplication;
import com.atshop.search.entity.OrderInfo;
import com.atshop.search.entity.PmsSearchCrumb;
import io.searchbox.client.JestResult;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class ElasticSearchUtilTest {

    @Autowired
    ElasticSearchUtil elasticSearchUtil;

    @Test
    public void deleteIndex() {
    }

    @Test
    public void clearCache() {
    }

    @Test
    public void closeIndex() {
    }

    @Test
    public void optimizeIndex() {
    }

    @Test
    public void flushIndex() {
    }

    @Test
    public void indicesExists() {
    }

    @Test
    public void nodesInfo() {
    }

    @Test
    public void health() {
        JestResult health = elasticSearchUtil.health();
        System.out.println(health.getJsonString());

    }

    @Test
    public void nodesStats() {
        JestResult jestResult = elasticSearchUtil.nodesStats();
        System.out.println(jestResult.getJsonString());
    }

    @Test
    public void createMapping() throws IOException {
        String file = this.getClass().getClassLoader().getResource("gmall.json").getFile();
        String s = FileUtils.readFileToString(new File(file), StandardCharsets.UTF_8.name());
        JestResult jestResult = elasticSearchUtil.createMapping(s,"gmall","skuInfo");
        System.out.println(jestResult.getJsonString());
    }


    @Test
    public void updateDocument() {
    }

    @Test
    public void deleteDocument() {
    }

    @Test
    public void deleteDocumentByQuery() {
    }

    @Test
    public void getDocument() {
    }

    @Test
    public void suggest() {
    }

    @Test
    public void searchAll() {
    }

    @Test
    public void createSearch() {
    }

    @Test
    public void bulkIndex() {
    }

    @Test
    public void createIndex() {
        PmsSearchCrumb pmsSearchCrumb = new PmsSearchCrumb();
        pmsSearchCrumb.setUrlParam("haha");
        pmsSearchCrumb.setValueId("products");
        pmsSearchCrumb.setValueName("dms");
        JestResult result = elasticSearchUtil.createIndex(pmsSearchCrumb, "utils-test", "ss");
        System.out.println(result);

    }

    @Test
    public void searchEvent() {
    }
}