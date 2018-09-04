package com.liagn.eurekafeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="lianghua")
@Component
public interface EurekaClientFeign {
    @GetMapping(value = "/hi")
    String sayHiFromClientEurka(@RequestParam(value="name") String name);
}
