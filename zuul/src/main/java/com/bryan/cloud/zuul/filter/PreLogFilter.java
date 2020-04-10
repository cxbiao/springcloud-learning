package com.bryan.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

@Slf4j
@Component
public class PreLogFilter extends ZuulFilter {

    /*
    * pre: 这种过滤器在请求被路由之前调用。可利用这种过滤器实现身份验证、在集群中选择请求的微服务，记录调试信息等。
      routing: 这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用apache httpclient或netflix ribbon请求微服务。
      post: 这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的http header、收集统计信息和指标、将响应从微服务发送给客户端等。
      error: 在其他阶段发送错误时执行该过滤器。
    *
    * */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return RequestContext.getCurrentContext().sendZuulResponse();
    }

    @Override
    public Object run() throws ZuulException {
      //  RequestContext currentContext = RequestContext.getCurrentContext();
      //  HttpServletRequest request = currentContext.getRequest();
//        log.info("zuul pre filter-->" + request.getRequestURL() + "-->" + request.getMethod());

        try {
            RequestContext rct = RequestContext.getCurrentContext();
            HttpServletRequest request = rct.getRequest();

            InputStream in = request.getInputStream();
            String method = request.getMethod();
            String path = request.getRequestURI();
            String contentType = request.getContentType();
            log.info("请求日志PreFilter:url={},method={},contentType={}", path,method,contentType);
            String reqBody = StreamUtils.copyToString(in, Charset.forName("UTF-8"));

            if (intercept(request)) {
                if(HttpMethod.GET.matches(method.toUpperCase())){
                    Map<String, String[]> map = request.getParameterMap();
                    if (map != null && map.size()>0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("{");
                        for (Map.Entry<String, String[]> entry : map.entrySet()) {
                            String key = entry.getKey();
                            String value = printArray(entry.getValue());
                            sb.append("[" + key + "=" + value + "]");
                        }
                        sb.append("}");
                        log.info("reqParam={}",sb.toString());
                    }
                }else if(HttpMethod.POST.matches(method.toUpperCase())){
                    if (!StringUtils.isEmpty(reqBody)) {
                        log.info("reqBody={}",reqBody);
                    }
                }

            }
        }catch (Exception ex){
            log.error("log request error", ex.getMessage(), ex);
        }


        return null;
    }

    private boolean intercept(HttpServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null || contentType.isEmpty()) return true;
        if (contentType.contains(MediaType.MULTIPART_FORM_DATA_VALUE) ||
                contentType.contains(MediaType.MULTIPART_MIXED_VALUE)) {
            return false;
        }
        return true;
    }

    public String printArray(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
