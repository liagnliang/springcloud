package com.liagn.eurekazuulclient;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Component
public class MyFilter extends ZuulFilter {

    private final Logger logger= Logger.getLogger("MyFilter");
    @Override
    public  String filterType(){
        return "pre";
    }

    @Override
    public int filterOrder(){
        return 0;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        logger.info("-->>> MyFilter: "+request.getMethod()+" "+request.getRequestURL().toString());
        String token=request.getParameter("token");//获取请求的参数
        if(StringUtils.isNotBlank(token)){
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess",true);
            return null;
        }else{
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess",false);
            return null;
        }
    }
}
