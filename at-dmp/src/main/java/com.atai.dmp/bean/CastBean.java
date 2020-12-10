package com.atai.dmp.bean;

import com.atai.dmp.entity.DataelementEntity;

import java.sql.Timestamp;


public class CastBean {

    private String id;
    private String code;
    private String chname;
    private String chcharacter;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getChcharacter() {
        return chcharacter;
    }

    public void setChcharacter(String chcharacter) {
        this.chcharacter = chcharacter;
    }

    public String getDataelementclassifyid() {
        return dataelementclassifyid;
    }

    public void setDataelementclassifyid(String dataelementclassifyid) {
        this.dataelementclassifyid = dataelementclassifyid;
    }

    public CastBean(DataelementEntity entity, String dataelementclassifyid) {
        this.dataelementclassifyid = dataelementclassifyid;
        this.id = entity.getId();
        this.code=entity.getCode();
        this.chcharacter=entity.getChcharacter();
    }

    private String dataelementclassifyid;




}
