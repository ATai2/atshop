package com.lee.gmall.resp;

import com.lee.gmall.bean.BaseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

@RestControllerAdvice
public class ResultHandler implements ResponseBodyAdvice<Object> {

//    @Override
//    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
//        Method method = returnType.getMethod();
////        SysLog sysLog = method.getAnnotation(SysLog.class);
////        if(sysLog != null) {
////             只处理含有SysLog注解的方法
//            return true;
////        }
////        return false;
//    }

//    查看是否是swagger获取数据会发生问题？ 是的
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();
        Class<?> containingClass = methodParameter.getContainingClass();
        SysLog annotation = containingClass.getAnnotation(SysLog.class);
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if(sysLog != null ||annotation!=null) {
            // 只处理含有SysLog注解的方法
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // 修改返回值类型
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        result.setData(body);
        return result;
    }

}
