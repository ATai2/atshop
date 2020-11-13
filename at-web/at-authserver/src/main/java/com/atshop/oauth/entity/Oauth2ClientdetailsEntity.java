package com.atshop.oauth.entity;

import javax.persistence.*;

@Entity
@Table(name = "oauth2_clientdetails", schema = "dmp", catalog = "")
public class Oauth2ClientdetailsEntity {
    private String appId;
    private String resourceIds;
    private String appSecret;
    private String scope;
    private String grantTypes;
    private String redirectUrl;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoApproveScopes;

    @Id
    @Column(name = "appId")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "resourceIds")
    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    @Basic
    @Column(name = "appSecret")
    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
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
    @Column(name = "grantTypes")
    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    @Basic
    @Column(name = "redirectUrl")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Basic
    @Column(name = "authorities")
    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Basic
    @Column(name = "access_token_validity")
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    @Basic
    @Column(name = "refresh_token_validity")
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    @Basic
    @Column(name = "additionalInformation")
    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Basic
    @Column(name = "autoApproveScopes")
    public String getAutoApproveScopes() {
        return autoApproveScopes;
    }

    public void setAutoApproveScopes(String autoApproveScopes) {
        this.autoApproveScopes = autoApproveScopes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oauth2ClientdetailsEntity that = (Oauth2ClientdetailsEntity) o;

        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (resourceIds != null ? !resourceIds.equals(that.resourceIds) : that.resourceIds != null) return false;
        if (appSecret != null ? !appSecret.equals(that.appSecret) : that.appSecret != null) return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;
        if (grantTypes != null ? !grantTypes.equals(that.grantTypes) : that.grantTypes != null) return false;
        if (redirectUrl != null ? !redirectUrl.equals(that.redirectUrl) : that.redirectUrl != null) return false;
        if (authorities != null ? !authorities.equals(that.authorities) : that.authorities != null) return false;
        if (accessTokenValidity != null ? !accessTokenValidity.equals(that.accessTokenValidity) : that.accessTokenValidity != null)
            return false;
        if (refreshTokenValidity != null ? !refreshTokenValidity.equals(that.refreshTokenValidity) : that.refreshTokenValidity != null)
            return false;
        if (additionalInformation != null ? !additionalInformation.equals(that.additionalInformation) : that.additionalInformation != null)
            return false;
        if (autoApproveScopes != null ? !autoApproveScopes.equals(that.autoApproveScopes) : that.autoApproveScopes != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = appId != null ? appId.hashCode() : 0;
        result = 31 * result + (resourceIds != null ? resourceIds.hashCode() : 0);
        result = 31 * result + (appSecret != null ? appSecret.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (grantTypes != null ? grantTypes.hashCode() : 0);
        result = 31 * result + (redirectUrl != null ? redirectUrl.hashCode() : 0);
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        result = 31 * result + (accessTokenValidity != null ? accessTokenValidity.hashCode() : 0);
        result = 31 * result + (refreshTokenValidity != null ? refreshTokenValidity.hashCode() : 0);
        result = 31 * result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
        result = 31 * result + (autoApproveScopes != null ? autoApproveScopes.hashCode() : 0);
        return result;
    }
}
