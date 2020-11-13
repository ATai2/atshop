package com.atshop.oauth.entity;


import lombok.Data;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "oauth_client_details")
@Data
public class OAuthClientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String clientId;
    @Column(length = 256)
    private String resourceIds;
    @Column(length = 256)
    private String scope;
    @Column(length = 256)
    private String authorizedGrantTypes;
    @Column(length = 256)
    private String webServerRedirectUir;
    @Column(length = 256)
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    @Column(length = 4096)
    private String additionalInformation;
    @Column(length = 256)
    private String autoApprove;
}
