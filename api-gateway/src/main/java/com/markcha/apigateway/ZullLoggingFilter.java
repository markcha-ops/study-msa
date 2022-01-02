package com.markcha.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class ZullLoggingFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getHeader("Authorization"));
        log.debug("Request Method : " + request.getMethod());
        log.debug("Request URL : " + request.getRequestURL().toString());

        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        ctx.getResponse().setHeader("Authorization", request.getHeader("Authorization"));
        ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));
        ctx.addZuulResponseHeader("Authorization", request.getHeader("Authorization"));
//        HttpServletRequest request =
//                RequestContext.getCurrentContext().getRequest();
//        logger.info("request -> {} request uri -> {}",
//                request, request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }
    private boolean validateToken(String tokenHeader) {
        // do something to validate the token
        return true;
    }
}
