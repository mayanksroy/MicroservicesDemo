//package com.wipro.gateway.filter;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//
//import reactor.core.publisher.Mono;
//
//@Component
//public class LoggingFilter implements GlobalFilter, Ordered {
//
//    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // Retrieve or generate Trace ID
//        final String traceId = exchange.getRequest().getHeaders().getFirst("X-B3-TraceId");
//
//        logger.info("🌍 API Gateway - Incoming Request: {} | Trace ID: {}", 
//                    exchange.getRequest().getURI(), (traceId != null ? traceId : "N/A"));
//
//        return chain.filter(exchange)
//                .doOnSuccess(aVoid -> 
//                    logger.info("✅ API Gateway - Response Sent: {} | Trace ID: {}", 
//                                exchange.getRequest().getURI(), (traceId != null ? traceId : "N/A"))
//                );
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
//
//
