package com.liagn.eurekaribbonclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    public String hi(@RequestParam(required = false,defaultValue = "liagn")String name){
        return restTemplate.getForEntity("http://lianghua/hi?name={1}",String.class,"liagn").getBody();
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
