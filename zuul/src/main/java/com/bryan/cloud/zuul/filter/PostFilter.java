package com.bryan.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Slf4j
@Component
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
        try {
            log.info("响应日志PostFilter");

//        try {
            //    int i = 1 / 0;
//        }catch (Exception e) {
//            rct.set("error.status_code",HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            rct.set("error.exception",e);
//        }

            RequestContext rct = RequestContext.getCurrentContext();
            HttpServletRequest request = rct.getRequest();

            // 打印response
            InputStream out = rct.getResponseDataStream();
            String outBody = StreamUtils.copyToString(out, Charset.forName("UTF-8"));
            if (!StringUtils.isEmpty(outBody)) {
                log.info("responseBody={}",outBody);
            }
            //必须重新写入流//重要！！！
            rct.getResponse().setCharacterEncoding("UTF-8");
            rct.setResponseBody(outBody);

        } catch (Exception ex) {
            log.error("log response error", ex.getMessage(), ex);
        }


        return null;
    }

    private void printLog() throws IOException {


    }



}
