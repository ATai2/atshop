package com.atshop.oauth.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;

@Entity
@Table(name = "oauth2_oauth_code", schema = "dmp", catalog = "")
public class Oauth2OauthCodeEntity {
    private String code;
    private byte[] authentication;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

        Oauth2OauthCodeEntity that = (Oauth2OauthCodeEntity) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (!Arrays.equals(authentication, that.authentication)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(authentication);
        return result;
    }
}
