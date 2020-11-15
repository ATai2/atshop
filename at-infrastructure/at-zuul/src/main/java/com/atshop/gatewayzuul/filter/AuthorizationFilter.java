package com.atshop.gatewayzuul.filter;

import com.atshop.gatewayzuul.domain.TokenInfo;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Slf4j
@Component
public class AuthorizationFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("AuthorizationFilter start");

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        if (isNeedAuth(request)) {
            TokenInfo tokenInfo = (TokenInfo) request.getAttribute("tokenInfo");
            if (tokenInfo != null && tokenInfo.isActive()) {
                if (!hasPermission(tokenInfo, request)) {
                    log.info("audit log update fail 403");
                    handleError(403, currentContext);
                }
                currentContext.addZuulRequestHeader("username",tokenInfo.getUserName());

            } else {
                if (!StringUtils.startsWithIgnoreCase(request.getRequestURI(), "/token")) {
                    log.info("audit log update fail 401");
                    handleError(401, currentContext);
                }
            }
        }

        return null;
    }

    private void handleError(int i, RequestContext currentContext) {
        currentContext.getResponse().setContentType("application/json");
        currentContext.setResponseStatusCode(i);
//        HashMap<String,String>
        currentContext.setResponseBody("{\"msg\":\"auth fail!\"");


    }

    private boolean hasPermission(TokenInfo tokenInfo, HttpServletRequest request) {
//        mock
        return RandomUtils.nextInt() % 2 == 0;
    }

    private boolean isNeedAuth(HttpServletRequest request) {
        return true;
    }
}
