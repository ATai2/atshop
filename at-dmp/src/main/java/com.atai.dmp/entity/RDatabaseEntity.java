package com.atai.dmp.entity;

import org.hibernate.annotations.Fetch;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "R_DATABASE")
public class RDatabaseEntity implements Serializable {
    private Long idDatabase;
    private String name;
    private Integer idDatabaseType;
    private Integer idDatabaseContype;
    private String hostName;
    private String databaseName;
    private Integer port;
    private String username;
    private String password;
    private String servername;
    private String dataTbs;
    private String indexTbs;

    @Id
    @Column(name = "ID_DATABASE", nullable = false)
    public Long getIdDatabase() {
        return idDatabase;
    }

    public void setIdDatabase(Long idDatabase) {
        this.idDatabase = idDatabase;
    }

    @Basic
    @Column(name = "\"NAME\"", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ID_DATABASE_TYPE", nullable = true)
    public Integer getIdDatabaseType() {
        return idDatabaseType;
    }

    public void setIdDatabaseType(Integer idDatabaseType) {
        this.idDatabaseType = idDatabaseType;
    }

    @Basic
    @Column(name = "ID_DATABASE_CONTYPE", nullable = true)
    public Integer getIdDatabaseContype() {
        return idDatabaseContype;
    }

    public void setIdDatabaseContype(Integer idDatabaseContype) {
        this.idDatabaseContype = idDatabaseContype;
    }

    @Basic
    @Column(name = "HOST_NAME", nullable = true, length = 255)
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    @Basic
    @Lob
    @Lazy(value = false)
    @org.hibernate.annotations.Type(type="org.hibernate.type.TextType")
    @Column(name = "DATABASE_NAME", nullable = true)
    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    @Basic
    @Column(name = "PORT", nullable = true)
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Basic
    @Column(name = "USERNAME", nullable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "\"PASSWORD\"", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "SERVERNAME", nullable = true, length = 255)
    public String getServername() {
        return servername;
    }

    public void setServername(String servername) {
        this.servername = servername;
    }

    @Basic
    @Column(name = "DATA_TBS", nullable = true, length = 255)
    public String getDataTbs() {
        return dataTbs;
    }

    public void setDataTbs(String dataTbs) {
        this.dataTbs = dataTbs;
    }

    @Basic
    @Column(name = "INDEX_TBS", nullable = true, length = 255)
    public String getIndexTbs() {
        return indexTbs;
    }

    public void setIndexTbs(String indexTbs) {
        this.indexTbs = indexTbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RDatabaseEntity that = (RDatabaseEntity) o;
        return Objects.equals(idDatabase, that.idDatabase) &&
                Objects.equals(name, that.name) &&
                Objects.equals(idDatabaseType, that.idDatabaseType) &&
                Objects.equals(idDatabaseContype, that.idDatabaseContype) &&
                Objects.equals(hostName, that.hostName) &&
                Objects.equals(databaseName, that.databaseName) &&
                Objects.equals(port, that.port) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(servername, that.servername) &&
                Objects.equals(dataTbs, that.dataTbs) &&
                Objects.equals(indexTbs, that.indexTbs);
    }

    @Override
    public String toString() {
        return "RDatabaseEntity{" +
                "idDatabase=" + idDatabase +
                ", name='" + name + '\'' +
                ", idDatabaseType=" + idDatabaseType +
                ", idDatabaseContype=" + idDatabaseContype +
                ", hostName='" + hostName + '\'' +
                ", databaseName='" + databaseName + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", servername='" + servername + '\'' +
                ", dataTbs='" + dataTbs + '\'' +
                ", indexTbs='" + indexTbs + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDatabase, name, idDatabaseType, idDatabaseContype, hostName, databaseName, port, username, password, servername, dataTbs, indexTbs);
    }
}
