package com.atshop.goods.entity;

import javax.persistence.Id;
import java.io.Serializable;

public class PmsBrand  implements Serializable {

    @Id
    private String id;
    private String        name;
    private String firstLetter;
    private int         sort;
    private int factoryStatus;
    private int         showStatus;
    private int productCount;
    private String         productCommentCount;
    private String logo;
    private String         bigPic;
    private String brandStory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(int factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public int getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(int showStatus) {
        this.showStatus = showStatus;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(String productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
