package com.atshop.security.log;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

@EntityListeners(AuditingEntityListener.class)
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String method;
    private String path;
    private Integer status;

    @CreatedBy
    @LastModifiedBy
    private String username;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;

}
