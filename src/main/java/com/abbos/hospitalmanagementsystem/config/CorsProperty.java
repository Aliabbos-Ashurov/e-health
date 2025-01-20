package com.abbos.hospitalmanagementsystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:21
 **/
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "cors")
public class CorsProperty {
    private List<String> allowedHeaders;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private String urlPattern;
    private boolean allowCredentials;
}
