package com.atai.dmp.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 组件属性实体类
 */
@Entity
@Table(name = "R_STEP_ATTRIBUTE")
@IdClass(RStepAttributeEntity.RStepAttributeEntityPK.class)
public class RStepAttributeEntity implements Serializable {
    /**
     * 组件属性id
     */
    @Column(name = "ID_STEP_ATTRIBUTE", nullable = true)
    private Integer idStepAttribute;
    /**
     * 转换id
     */
    @Column(name = "ID_TRANSFORMATION", nullable = true)
    private Integer idTransformation;
    /**
     * 组件id
     */
    @Id
    @Column(name = "ID_STEP", nullable = true)
    private Integer idStep;
    /**
     * 编号
     */
    @Id
    @Column(name = "NR", nullable = true)
    private Integer nr;
    /**
     * 属性代码
     */
    @Id
    @Column(name = "CODE", nullable = true, length = 255)
    private String code;
    /**
     * 属性值—数字型
     */
    @Column(name = "VALUE_NUM", nullable = true)
    private Integer valueNum = 0;
    /**
     * 属性值—字符型
     */
    @Lazy(value = false)
    @Lob
//    @org.hibernate.annotations.Type(type = "org.hibernate.type.MaterializedClobType")
    @Column(name = "VALUE_STR", nullable = true)
    private String valueStr;


    public RStepAttributeEntity() {
    }

    public RStepAttributeEntity(Integer idTrans, String code, Integer nr, Integer idStepAttribute, Integer idStep, Integer valueNum, String valueStr) {
        this.idTransformation = idTrans;
        this.code = code;
        this.nr = nr;
        this.idStepAttribute = idStepAttribute;
        this.idStep = idStep;
        this.valueNum = valueNum;
        this.valueStr = valueStr;
    }

    public RStepAttributeEntity(Integer idStepAttribute, Integer idTransformation, Integer idStep, Integer nr, String code, Integer valueNum, String valueStr) {
        this.idStepAttribute = idStepAttribute;
        this.idTransformation = idTransformation;
        this.idStep = idStep;
        this.nr = nr;
        this.code = code;
        this.valueNum = valueNum;
        this.valueStr = valueStr;
    }

    public int getIdStepAttribute() {
        return idStepAttribute;
    }

    public void setIdStepAttribute(Integer idStepAttribute) {
        this.idStepAttribute = idStepAttribute;
    }

    public Integer getIdTransformation() {
        return idTransformation;
    }

    public void setIdTransformation(Integer idTransformation) {
        this.idTransformation = idTransformation;
    }

    public Integer getIdStep() {
        return idStep;
    }

    public void setIdStep(Integer idStep) {
        this.idStep = idStep;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getValueNum() {
        return valueNum;
    }

    public void setValueNum(Integer valueNum) {
        this.valueNum = valueNum;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    @Override
    public String toString() {
        return "RStepAttributeEntity{" +
                "idTransformation=" + idTransformation +
                ", code='" + code + '\'' +
                ", nr=" + nr +
                ", idStepAttribute=" + idStepAttribute +
                ", idStep=" + idStep +
                ", valueNum=" + valueNum +
                ", valueStr='" + valueStr + '\'' +
                '}';
    }

    /**
     * 组件属性主键实体类
     */
    public static class RStepAttributeEntityPK implements Serializable {
        private static final long serialVersionUID = 1L;

        /**
         * 组件id
         */
        private int idStep;
        /**
         * 编号
         */
        private int nr;
        /**
         * 属性代码
         */
        private String code;

        public RStepAttributeEntityPK() {
        }

        public RStepAttributeEntityPK(Integer idStep, String code, Integer nr) {
            this.idStep = idStep;
            this.code = code;
            this.nr = nr;
        }

        public int getIdStep() {
            return idStep;
        }

        public void setIdStep(int idStep) {
            this.idStep = idStep;
        }

        public int getNr() {
            return nr;
        }

        public void setNr(int nr) {
            this.nr = nr;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RStepAttributeEntityPK that = (RStepAttributeEntityPK) o;
            return Objects.equals(idStep, that.idStep) &&
                    Objects.equals(code, that.code) &&
                    Objects.equals(nr, that.nr);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idStep, code, nr);
        }

        @Override
        public String toString() {
            return "RStepAttrPK{" +
                    "idStep=" + idStep +
                    ", code='" + code + '\'' +
                    ", nr=" + nr +
                    '}';
        }
    }
}
