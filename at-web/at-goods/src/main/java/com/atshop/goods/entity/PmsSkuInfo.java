package com.atshop.goods.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @param
 * @return
 */
public class PmsSkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;

    @Column
    String productId;

    @Column
    BigDecimal price;

    @Column
    String skuName;

    @Column
    BigDecimal weight;

    @Column
    String skuDesc;

    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;

    @Transient
    List<PmsSkuImage> pmsSkuImageList;

    @Transient
    List<PmsSkuAttrValue> pmsSkuAttrValueList;

    @Transient
    List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public String getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(String catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getSkuDefaultImg() {
        return skuDefaultImg;
    }

    public void setSkuDefaultImg(String skuDefaultImg) {
        this.skuDefaultImg = skuDefaultImg;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<PmsSkuImage> getPmsSkuImageList() {
        return pmsSkuImageList;
    }

    public void setPmsSkuImageList(List<PmsSkuImage> pmsSkuImageList) {
        this.pmsSkuImageList = pmsSkuImageList;
    }

    public List<PmsSkuAttrValue> getPmsSkuAttrValueList() {
        return pmsSkuAttrValueList;
    }

    public void setPmsSkuAttrValueList(List<PmsSkuAttrValue> pmsSkuAttrValueList) {
        this.pmsSkuAttrValueList = pmsSkuAttrValueList;
    }

    public List<PmsSkuSaleAttrValue> getPmsSkuSaleAttrValueList() {
        return pmsSkuSaleAttrValueList;
    }

    public void setPmsSkuSaleAttrValueList(List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList) {
        this.pmsSkuSaleAttrValueList = pmsSkuSaleAttrValueList;
    }
}
