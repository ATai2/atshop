package com.atshop.oauth.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "oauth_approvals")
public class Oauth2OauthApprovalsEntity {
    private String userId;
    private String clientId;
    private String scope;
    private String status;
    private Timestamp expiresAt;
    private Timestamp lastModifiedAt;

    @Id
    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "clientId")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "expiresAt")
    public Timestamp getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Timestamp expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Basic
    @Column(name = "lastModifiedAt")
    public Timestamp getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(Timestamp lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oauth2OauthApprovalsEntity that = (Oauth2OauthApprovalsEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (expiresAt != null ? !expiresAt.equals(that.expiresAt) : that.expiresAt != null) return false;
        if (lastModifiedAt != null ? !lastModifiedAt.equals(that.lastModifiedAt) : that.lastModifiedAt != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
        result = 31 * result + (lastModifiedAt != null ? lastModifiedAt.hashCode() : 0);
        return result;
    }
}
