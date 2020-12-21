package com.atshop.goods.service.impl;

import com.alibaba.fastjson.JSON;

import com.at.common.bean.PmsSkuAttrValue;
import com.at.common.bean.PmsSkuImage;
import com.at.common.bean.PmsSkuInfo;
import com.at.common.bean.PmsSkuSaleAttrValue;
import com.atshop.goods.mapper.PmsSkuAttrValueMapper;
import com.atshop.goods.mapper.PmsSkuImageMapper;
import com.atshop.goods.mapper.PmsSkuInfoMapper;
import com.atshop.goods.mapper.PmsSkuSaleAttrValueMapper;
import com.atshop.goods.service.SkuService;
import com.atshop.goods.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        // 插入skuInfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }
    }


    public PmsSkuInfo getSkuByIdFromDb(String skuId) {
        // sku商品对象
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        pmsSkuInfo.setId(skuId);
        PmsSkuInfo skuInfo = pmsSkuInfoMapper.selectOne(pmsSkuInfo);

        // sku的图片集合
        PmsSkuImage pmsSkuImage = new PmsSkuImage();
        pmsSkuImage.setSkuId(skuId);
        List<PmsSkuImage> pmsSkuImages = pmsSkuImageMapper.select(pmsSkuImage);
        skuInfo.setSkuImageList(pmsSkuImages);
        return skuInfo;
    }

    @Override
    public PmsSkuInfo getSkuById(String skuId) {
        PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
        // 链接缓存
        Jedis jedis = redisUtil.getJedis();
        // 查询缓存
        String skuKey = "sku:" + skuId + ":info";
        String skuJson = jedis.get(skuKey);

        if (StringUtils.isNotBlank(skuJson)) {//if(skuJson!=null&&!skuJson.equals(""))
            pmsSkuInfo = JSON.parseObject(skuJson, PmsSkuInfo.class);
        } else {
            // 如果缓存中没有，查询mysql

            // 设置分布式锁
            Long OK = jedis.setnx("sku:" + skuId + ":lock", "1");
            if (OK == 1L) {
                // 设置成功，有权在10秒的过期时间内访问数据库
                pmsSkuInfo = getSkuByIdFromDb(skuId);
                if (pmsSkuInfo != null) {
                    // mysql查询结果存入redis
                    jedis.set("sku:" + skuId + ":info", JSON.toJSONString(pmsSkuInfo));
                } else {
                    // 数据库中不存在该sku
                    // 为了防止缓存穿透将，null或者空字符串值设置给redis
                    jedis.setex("sku:" + skuId + ":info", 60 * 3, JSON.toJSONString(""));
                }
            } else {
                // 设置失败，自旋（该线程在睡眠几秒后，重新尝试访问本方法）
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getSkuById(skuId);
            }
        }
        jedis.close();
        return pmsSkuInfo;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId) {
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoMapper.selectSkuSaleAttrValueListBySpu(productId);
        return pmsSkuInfos;
    }

    @Override
    public List<PmsSkuInfo> getAllSku(String catalog3Id) {
        return null;
    }
}
