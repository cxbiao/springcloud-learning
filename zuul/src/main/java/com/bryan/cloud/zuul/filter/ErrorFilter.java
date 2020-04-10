package com.bryan.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
        log.info("ErrorFilter");
        RequestContext rct = RequestContext.getCurrentContext();


//        try {
//            int i = 1 / 0;
//        }catch (Exception e) {
//            rct.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            rct.set("error.exception",e);
//        }


        return null;
    }
}
