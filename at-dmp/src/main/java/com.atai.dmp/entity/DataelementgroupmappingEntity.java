package com.atai.dmp.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
@Entity
@Table(name = "DATAELEMENTGROUPMAPPING")
public class DataelementgroupmappingEntity  implements Serializable {
    private String id;
    private String dataelementid;
    private String dataelementclassifyid;

    @Id
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATAELEMENTID", nullable = false, length = 36)
    public String getDataelementid() {
        return dataelementid;
    }

    public void setDataelementid(String dataelementid) {
        this.dataelementid = dataelementid;
    }

    @Basic
    @Column(name = "DATAELEMENTCLASSIFYID", nullable = false, length = 36)
    public String getDataelementclassifyid() {
        return dataelementclassifyid;
    }

    public void setDataelementclassifyid(String dataelementclassifyid) {
        this.dataelementclassifyid = dataelementclassifyid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataelementgroupmappingEntity that = (DataelementgroupmappingEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataelementid, that.dataelementid) &&
                Objects.equals(dataelementclassifyid, that.dataelementclassifyid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataelementid, dataelementclassifyid);
    }
}
