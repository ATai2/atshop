package com.atshop.order.entity;

import io.searchbox.annotations.JestId;

public class PmsSearchCrumb {

    @JestId
    private String valueId;
    private String valueName;
    private String urlParam;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getUrlParam() {
        return urlParam;
    }

    public void setUrlParam(String urlParam) {
        this.urlParam = urlParam;
    }
}
