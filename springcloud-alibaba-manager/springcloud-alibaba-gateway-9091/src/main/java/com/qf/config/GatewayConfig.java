package com.qf.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 因为在网关内部过滤器的顺序都是整数，我们自己在定义过滤器的时候，采用负数，数字越小越先执行
 */
@Configuration
public class GatewayConfig {

    @Bean
    @Order(-1)
    public GlobalFilter globalFilter() {
        return new GlobalFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                System.out.println("全局过滤器1");
                return chain.filter(exchange);
            }
        };
    }

    @Bean
    @Order(-2)
    public GlobalFilter secondGlobalFilter() {
        return new GlobalFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                System.out.println("全局过滤器2");
                return chain.filter(exchange);
            }
        };
    }
}
