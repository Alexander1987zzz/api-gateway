package com.highload.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class Config {
    @Bean
    RouteLocatorBuilder routeLocatorBuilder(ConfigurableApplicationContext context){
        return new RouteLocatorBuilder(context);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r.host("localhost:8081")
                        .and()
                        .path("/v1/dialog/**")
                        .uri("http://localhost:8081"))
                .route("r2", r -> r.host("localhost:8081")
                        .and()
                        .path("/v2/dialog/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
