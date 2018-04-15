package com.heowc;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulMainApplication.class, args);
    }

    @Component
    public static class CustomZuulFilter extends ZuulFilter {

        @Override
        public String filterType() {
            return ROUTE_TYPE; // PRE_TYPE, POST_TYPE, ROUTE_TYPE
        }

        @Override
        public int filterOrder() {
            return SIMPLE_HOST_ROUTING_FILTER_ORDER - 1;
        }

        @Override
        public boolean shouldFilter() {
            return RequestContext.getCurrentContext().getRouteHost() != null
                    && RequestContext.getCurrentContext().sendZuulResponse();
        }

        @Override
        public Object run() throws ZuulException {
            return null;
        }
    }
}
