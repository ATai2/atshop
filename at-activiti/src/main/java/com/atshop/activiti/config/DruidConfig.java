//package com.atshop.activiti.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//@Configuration
//@EnableConfigurationProperties({DruidDataSourceProperties.class})
//public class DruidConfig {
//    @Autowired
//    private DruidDataSourceProperties druidDataSourceProperties;
//
////    @Bean
////    @ConfigurationProperties(prefix="spring.datasource.druid")
////    //加载时读取指定的配置信息,前缀为spring.datasource.druid
////    public DataSource druidDataSource() {
////        return new DruidDataSource();
////    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public DataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(druidDataSourceProperties.getDriverClassName());
//        druidDataSource.setUrl(druidDataSourceProperties.getUrl());
//        druidDataSource.setUsername(druidDataSourceProperties.getUsername());
//        druidDataSource.setPassword(druidDataSourceProperties.getPassword());
//        druidDataSource.setInitialSize(druidDataSourceProperties.getInitialSize());
//        druidDataSource.setMinIdle(druidDataSourceProperties.getMinIdle());
//        druidDataSource.setMaxActive(druidDataSourceProperties.getMaxActive());
//        druidDataSource.setMaxWait(druidDataSourceProperties.getMaxWait());
//        druidDataSource.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.getTimeBetweenEvictionRunsMillis());
//        druidDataSource.setMinEvictableIdleTimeMillis(druidDataSourceProperties.getMinEvictableIdleTimeMillis());
//        druidDataSource.setValidationQuery(druidDataSourceProperties.getValidationQuery());
//        druidDataSource.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
//        druidDataSource.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
//        druidDataSource.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
//        druidDataSource.setPoolPreparedStatements(druidDataSourceProperties.isPoolPreparedStatements());
//        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(druidDataSourceProperties.getMaxPoolPreparedStatementPerConnectionSize());
//
//        try {
//            druidDataSource.setFilters(druidDataSourceProperties.getFilters());
//            druidDataSource.init();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return druidDataSource;
//    }
//    @Bean
//    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
//        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(),  "/druid/*");
//        registrationBean.addInitParameter("allow", "127.0.0.1");// IP白名单 (没有配置或者为空，则允许所有访问)
//        registrationBean.addInitParameter("deny", "");// IP黑名单 (存在共同时，deny优先于allow)
//        registrationBean.addInitParameter("loginUsername", "root");
//        registrationBean.addInitParameter("loginPassword", "1234");
//        registrationBean.addInitParameter("resetEnable", "false");
//        return registrationBean;
//    }
//
//}
