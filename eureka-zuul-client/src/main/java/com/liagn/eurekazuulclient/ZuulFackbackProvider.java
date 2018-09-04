package com.liagn.eurekazuulclient;

import org.springframework.http.client.ClientHttpResponse;

public interface ZuulFackbackProvider {
    public String getRoute();
    public ClientHttpResponse fallbackResponse();
}
