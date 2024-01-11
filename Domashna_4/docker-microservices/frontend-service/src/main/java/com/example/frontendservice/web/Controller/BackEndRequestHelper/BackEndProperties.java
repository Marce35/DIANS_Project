package com.example.frontendservice.web.Controller.BackEndRequestHelper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class BackEndProperties {
    public static String baseUrl = "http://backend-service:9091";

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static void setBaseUrl(String baseUrl) {
        BackEndProperties.baseUrl = baseUrl;
    }
}
