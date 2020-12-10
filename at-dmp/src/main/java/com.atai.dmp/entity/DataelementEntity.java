package com.atai.dmp.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.*;
@Entity
@Table(name = "DATAELEMENT")
public class DataelementEntity  implements Serializable {
    private String id;
    private String code;
    private String chname;
    private String chcharacter;
    private String enname;
    private String versions;
    private String explains;
    private String objectclasswords;
    private String featurewords;
    private String expressionword;
    private Integer datatype;
    private String dataformat;
    private String numrange;
    private String subordinateelement;
    private Integer states;
    private String fieldcriteria;
    private String measuringunit;
    private String orgid;
    private String context;
    private String applyconstraints;
    private String remarks;
    private Integer datalength;
    private Integer precision;
    private Integer isempty;
    private Timestamp createtime;
    private Timestamp lastmodifytime;

    @Override
    public String toString() {
        return "DataelementEntity{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", chname='" + chname + '\'' +
                ", chcharacter='" + chcharacter + '\'' +
                ", enname='" + enname + '\'' +
                ", versions='" + versions + '\'' +
                ", explains='" + explains + '\'' +
                ", objectclasswords='" + objectclasswords + '\'' +
                ", featurewords='" + featurewords + '\'' +
                ", expressionword='" + expressionword + '\'' +
                ", datatype=" + datatype +
                ", dataformat='" + dataformat + '\'' +
                ", numrange='" + numrange + '\'' +
                ", subordinateelement='" + subordinateelement + '\'' +
                ", states=" + states +
                ", fieldcriteria='" + fieldcriteria + '\'' +
                ", measuringunit='" + measuringunit + '\'' +
                ", orgid='" + orgid + '\'' +
                ", context='" + context + '\'' +
                ", applyconstraints='" + applyconstraints + '\'' +
                ", remarks='" + remarks + '\'' +
                ", datalength=" + datalength +
                ", precision=" + precision +
                ", isempty=" + isempty +
                ", createtime=" + createtime +
                ", lastmodifytime=" + lastmodifytime +
                '}';
    }

    @Id
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"CODE\"", nullable = false, length = 30)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "CHNAME", nullable = false, length = 36)
    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    @Basic
    @Column(name = "CHCHARACTER", nullable = true, length = 100)
    public String getChcharacter() {
        return chcharacter;
    }

    public void setChcharacter(String chcharacter) {
        this.chcharacter = chcharacter;
    }

    @Basic
    @Column(name = "ENNAME", nullable = false, length = 36)
    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    @Basic
    @Column(name = "\"VERSIONS\"", nullable = true, length = 3)
    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    @Basic
    @Column(name = "EXPLAINS", nullable = false, length = 100)
    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    @Basic
    @Column(name = "OBJECTCLASSWORDS", nullable = true, length = 36)
    public String getObjectclasswords() {
        return objectclasswords;
    }

    public void setObjectclasswords(String objectclasswords) {
        this.objectclasswords = objectclasswords;
    }

    @Basic
    @Column(name = "FEATUREWORDS", nullable = true, length = 36)
    public String getFeaturewords() {
        return featurewords;
    }

    public void setFeaturewords(String featurewords) {
        this.featurewords = featurewords;
    }

    @Basic
    @Column(name = "EXPRESSIONWORD", nullable = true, length = 36)
    public String getExpressionword() {
        return expressionword;
    }

    public void setExpressionword(String expressionword) {
        this.expressionword = expressionword;
    }

    @Basic
    @Column(name = "DATATYPE", nullable = false)
    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    @Basic
    @Column(name = "DATAFORMAT", nullable = true, length = 36)
    public String getDataformat() {
        return dataformat;
    }

    public void setDataformat(String dataformat) {
        this.dataformat = dataformat;
    }

    @Basic
    @Column(name = "NUMRANGE", nullable = true, length = 300)
    public String getNumrange() {
        return numrange;
    }

    public void setNumrange(String numrange) {
        this.numrange = numrange;
    }

    @Basic
    @Column(name = "SUBORDINATEELEMENT", nullable = true, length = 36)
    public String getSubordinateelement() {
        return subordinateelement;
    }

    public void setSubordinateelement(String subordinateelement) {
        this.subordinateelement = subordinateelement;
    }

    @Basic
    @Column(name = "STATES", nullable = true)
    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    @Basic
    @Column(name = "FIELDCRITERIA", nullable = true, length = 36)
    public String getFieldcriteria() {
        return fieldcriteria;
    }

    public void setFieldcriteria(String fieldcriteria) {
        this.fieldcriteria = fieldcriteria;
    }

    @Basic
    @Column(name = "MEASURINGUNIT", nullable = true, length = 36)
    public String getMeasuringunit() {
        return measuringunit;
    }

    public void setMeasuringunit(String measuringunit) {
        this.measuringunit = measuringunit;
    }

    @Basic
    @Column(name = "ORGID", nullable = true, length = 36)
    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    @Basic
    @Column(name = "\"CONTEXT\"", nullable = true, length = 100)
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Basic
    @Column(name = "APPLYCONSTRAINTS", nullable = true, length = 100)
    public String getApplyconstraints() {
        return applyconstraints;
    }

    public void setApplyconstraints(String applyconstraints) {
        this.applyconstraints = applyconstraints;
    }

    @Basic
    @Column(name = "REMARKS", nullable = true, length = 500)
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Basic
    @Column(name = "DATALENGTH", nullable = true)
    public Integer getDatalength() {
        return datalength;
    }

    public void setDatalength(Integer datalength) {
        this.datalength = datalength;
    }

    @Basic
    @Column(name = "\"PRECISION\"", nullable = true)
    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    @Basic
    @Column(name = "ISEMPTY", nullable = true)
    public Integer getIsempty() {
        return isempty;
    }

    public void setIsempty(Integer isempty) {
        this.isempty = isempty;
    }

    @Basic
    @Column(name = "CREATETIME", nullable = true)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "LASTMODIFYTIME", nullable = true)
    public Timestamp getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Timestamp lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataelementEntity that = (DataelementEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(chname, that.chname) &&
                Objects.equals(chcharacter, that.chcharacter) &&
                Objects.equals(enname, that.enname) &&
                Objects.equals(versions, that.versions) &&
                Objects.equals(explains, that.explains) &&
                Objects.equals(objectclasswords, that.objectclasswords) &&
                Objects.equals(featurewords, that.featurewords) &&
                Objects.equals(expressionword, that.expressionword) &&
                Objects.equals(datatype, that.datatype) &&
                Objects.equals(dataformat, that.dataformat) &&
                Objects.equals(numrange, that.numrange) &&
                Objects.equals(subordinateelement, that.subordinateelement) &&
                Objects.equals(states, that.states) &&
                Objects.equals(fieldcriteria, that.fieldcriteria) &&
                Objects.equals(measuringunit, that.measuringunit) &&
                Objects.equals(orgid, that.orgid) &&
                Objects.equals(context, that.context) &&
                Objects.equals(applyconstraints, that.applyconstraints) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(datalength, that.datalength) &&
                Objects.equals(precision, that.precision) &&
                Objects.equals(isempty, that.isempty) &&
                Objects.equals(createtime, that.createtime) &&
                Objects.equals(lastmodifytime, that.lastmodifytime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, chname, chcharacter, enname, versions, explains, objectclasswords, featurewords, expressionword, datatype, dataformat, numrange, subordinateelement, states, fieldcriteria, measuringunit, orgid, context, applyconstraints, remarks, datalength, precision, isempty, createtime, lastmodifytime);
    }
}
