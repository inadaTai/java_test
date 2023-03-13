package com.example.test.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConf {

    @Bean
    public Docket swaggerPlugin() {
        return new Docket(DocumentationType.SWAGGER_2) // SWAGGER_12, SWAGGER_2, SWAGGER_WEBがあるがどれが良いのかあまりわからない
                .select() //ApiSelectorBuilderの生成
                .apis(RequestHandlerSelectors.any()) //ドキュメントの対象となるRequestHandlerを設定
                .paths(PathSelectors.regex("/v1.*")) //ドキュメントの対象となるPathを設定
                .build()
                .apiInfo(getApiInfo()); //ApiInfo型でAPIの基本情報設定
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("test-api")
                .description("testのAPI")
                .version("1.0.0")
                .contact(new Contact("nooboolean","webSiteUrl","email"))
                .build();
    }

    private Predicate<String> paths() {
        return Predicates.or(Predicates.containsPattern("/test"));
    }
}
