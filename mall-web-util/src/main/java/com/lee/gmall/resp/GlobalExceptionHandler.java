package com.lee.gmall.resp;

import com.lee.gmall.bean.BaseResult;
import io.netty.util.internal.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

//    // 业务异常处理方法
//    @ExceptionHandler(value = CommonException.class)
//    public Object CommonException(HttpServletRequest request, CommonException e, HandlerMethod handlerMethod) {
//        log.error("业务处理不成功，错误信息为：	{}", e.getMessage());
//        Method method = handlerMethod.getMethod();
//        if(method.getReturnType().equals(ModelAndView.class)) {
//            String view = (String) request.getAttribute(SessionKey.ERROR_RETURN_PAGE);
//            if(StringUtil.isNullOrEmpty(view)) {
//                view = "/index";
//            }
//            return new ModelAndView(view);
//        }
//        return new BaseResult(e);
//    }

    // 服务器异常处理方法
    @ExceptionHandler(value = Exception.class)
    public Object exception(HttpServletRequest request, Exception e, HandlerMethod handlerMethod) {
        log.error("服务器发生异常，异常信息为", e);
        Method method = handlerMethod.getMethod();
//        if(method.getReturnType().equals(ModelAndView.class)) {
//            String view = (String) request.getAttribute(SessionKey.ERROR_RETURN_PAGE);
//            if(StringUtil.isNullOrEmpty(view)) {
//                view = "/index";
//            }
//            return new ModelAndView(view);
//        }

        BaseResult errorResult = new BaseResult();
        errorResult.setSuccess(false);
        errorResult.setMsg(e.getMessage());
        return errorResult;
    }
}
