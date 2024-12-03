package br.com.msgateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigGateway {

    @Bean
    public RouteLocator custom(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("produtos", r -> r.path("/produtos/**")
                        .and()
                        .not(p->p.path("/api/**"))
                        .uri("http://localhost:8180/produtos"))
                .route("pedidos", r-> r.path("/pedidos/**")
                        .uri("http://localhost:8380"))
                .route("clientes", r-> r.path("/clientes/**")
                        .uri("http://localhost:8280"))
                .build();
    }
}
