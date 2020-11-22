package com.atshop.item.entity;

import java.io.Serializable;

/**
 * @param
 * @return
 */
public class PmsProductImage implements Serializable {

    private String id;
    private String productId;
    private String imgName;
    private String imgUrl;

    public PmsProductImage() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}