package com.coral.cgs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Gude.
 * @Date 2017/4/8.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        List<SecurityContext> security = new ArrayList<SecurityContext>();
        security.add(securityContext());
        /*return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any())
                //过滤生成链接
                .paths(PathSelectors.regex("/swagger/.*")).build().apiInfo(apiInfo());*/
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any())
                //过滤生成链接
                .paths(PathSelectors.any()).build().pathMapping("/").securityContexts(security).apiInfo(apiInfo());
    }
    //api接口作者相关信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("Coral", "https://github.com/Coralma", "maqujun@hotmail.com");
        ApiInfo apiInfo = new ApiInfoBuilder().title("Coral Test ").description("接口文档").contact(contact).version("1.0").build();
        return apiInfo;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .forPaths(PathSelectors.regex("/"))
                .build();
    }
}
