package com.bryan.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

@Slf4j
//@Component
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        log.info("PostFilter");
        RequestContext rct = RequestContext.getCurrentContext();
        rct.getResponse();
//        try {
        //    int i = 1 / 0;
//        }catch (Exception e) {
//            rct.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            rct.set("error.exception",e);
//        }
        return null;
    }
}
