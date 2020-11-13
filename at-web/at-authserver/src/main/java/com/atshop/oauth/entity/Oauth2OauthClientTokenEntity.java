package com.atshop.oauth.entity;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "oauth2_oauth_client_token", schema = "dmp", catalog = "")
public class Oauth2OauthClientTokenEntity {
    private String tokenId;
    private byte[] token;
    private String authenticationId;
    private String userName;
    private String clientId;

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

    @Id
    @Column(name = "authentication_id")
    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "client_id")
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oauth2OauthClientTokenEntity that = (Oauth2OauthClientTokenEntity) o;

        if (tokenId != null ? !tokenId.equals(that.tokenId) : that.tokenId != null) return false;
        if (!Arrays.equals(token, that.token)) return false;
        if (authenticationId != null ? !authenticationId.equals(that.authenticationId) : that.authenticationId != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tokenId != null ? tokenId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(token);
        result = 31 * result + (authenticationId != null ? authenticationId.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}
