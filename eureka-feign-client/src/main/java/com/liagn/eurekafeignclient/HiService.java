package com.liagn.eurekafeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HiService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEurka(name);
    }
}
