package com.atshop.gatewayzuul.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TokenInfo {

    private boolean active;
    private String clientId;
    private String[] scopes;
    private String userName;
    private String[] aud;
    private Date exp;

    private String[] authorities;
}
