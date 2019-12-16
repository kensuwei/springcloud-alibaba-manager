package com.qf.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * spring5.X 版本之后加入 webflux模块, 该模块主要用户反应式编程。
 *    如果要返回单个值(例如User), return Mono;
 *    如果要返回列表：return Flux;
 */
@Component
public class CustomizeGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    /**
     * Customize=abc,XYZ
     */
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        // 针对如上的配置，config.getName() 为abc, config.getValue()为XYZ
        System.out.println(config.getName() + ":::" + config.getValue());

        GatewayFilter gatewayFilter = new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                String username = request.getQueryParams().get("username").get(0);
                System.out.println(username);

                //该代码的意思是向请求头中添加信息  auth abcdef
                request.mutate().header("auth", "abcdef");

                // mutate是修改的意思, 将修改之后的request加入新的请求中
                ServerWebExchange serverWebExchange = exchange.mutate().request(request).build();

                return chain.filter(serverWebExchange);
            }
        };

        return gatewayFilter;
    }
}
