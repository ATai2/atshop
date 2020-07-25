package com.at.atshop.sqltrans.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class TransDataSourceProperties {
}
