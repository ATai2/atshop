package com.atshop.oauth.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "oauth2_oauth_refresh_token", schema = "dmp", catalog = "")
public class Oauth2OauthRefreshTokenEntity {
    private String tokenId;
    private byte[] token;
    private byte[] authentication;

    @Basic
    @Column(name = "token_id")
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    @Basic
    @Column(name = "token")
    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    @Basic
    @Column(name = "authentication")
    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oauth2OauthRefreshTokenEntity that = (Oauth2OauthRefreshTokenEntity) o;

        if (tokenId != null ? !tokenId.equals(that.tokenId) : that.tokenId != null) return false;
        if (!Arrays.equals(token, that.token)) return false;
        if (!Arrays.equals(authentication, that.authentication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tokenId != null ? tokenId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
