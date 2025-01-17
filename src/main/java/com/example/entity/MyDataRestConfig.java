package com.example.entity;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedHttpMethods={HttpMethod.DELETE,HttpMethod.PUT};
        config.getExposureConfiguration().forDomainType(Book.class).withItemExposure((metdata, http) ->http.disable(unsupportedHttpMethods) )
                .withCollectionExposure((metdata, http) ->http.disable(unsupportedHttpMethods));
    }
}
