package com.at.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket createRestApi() {
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter> parameters = new ArrayList<>();
//        parameterBuilder.name("token")
//                .description("令牌")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false)
//                .build();
//        parameters.add(parameterBuilder.build());
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.*.controller"))
////                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .globalOperationParameters(parameters);
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().build();
//    }
@Bean
public Docket createRestApi() {

    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.*.*.controller"))
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build();
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().build();
    }
}
