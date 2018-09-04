package com.liagn.web;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.client.ServiceInstance;
import org.apache.log4j.Logger;
import java.util.List;

/**
 * Created by Administrator on 2018/8/1.
 */

@RestController
public class HelloController {

    private final Logger logger= Logger.getLogger(getClass());
    @Autowired
    private Registration registration;//服务注册
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
        List<ServiceInstance> instance= client.getInstances(registration.getServiceId());
        logger.info("/hello,host:"+instance.get(0).getHost()+",service_id:"+instance.get(0).getServiceId());
        return "Hello provider";
    }
}
