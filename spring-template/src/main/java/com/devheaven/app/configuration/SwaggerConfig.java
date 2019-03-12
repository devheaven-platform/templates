package com.devheaven.app.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

/**
 * This class configures the Swagger UI & API.
 *
 * @author tomdewildt
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Configures the Swagger API.
     *
     * @return Docket with swagger information.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.devheaven.app"))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(metadata())//
                .useDefaultResponseMessages(false)
                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))
                .produces(new HashSet<String>() {{
                    add("application/json");
                }})
                .consumes(new HashSet<String>() {{
                    add("application/json");
                }})
                .genericModelSubstitutes(Optional.class);
    }

    /**
     * Configures the meta data for the Swagger API.
     *
     * @return ApiInfoBuild with details about the application.
     */
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("DevHeaven")
                .description("")
                .version("1.0.0")
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")
                .contact(new Contact("DevHeaven", "https://github.com/devheaven-platform/", null))
                .build();
    }

}
