package com.devheaven.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Configures the resource handlers for the Swagger UI.
 *
 * @author tomdewildt
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * Adds resource handlers for the swagger-ui since that automatic
     * mapping of resource handlers is disabled in settings.
     *
     * @param registry the resource handler registry.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

}
