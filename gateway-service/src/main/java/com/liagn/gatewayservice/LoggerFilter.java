package com.liagn.gatewayservice;

import brave.SpanCustomizer;
import com.netflix.zuul.ZuulFilter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import brave.Tracer;

import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;


@Component
public class LoggerFilter extends ZuulFilter {
    @Autowired
    Tracer tracer;
    private SpanCustomizer span;

    @Override
    public String filterType(){
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder(){
        return 900;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run(){
        this.span = tracer.nextSpan().name("name").start();
        span.tag("operator","liagn");
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println(span.toString());
        System.out.println("********************************");

        return null;
    }

}
