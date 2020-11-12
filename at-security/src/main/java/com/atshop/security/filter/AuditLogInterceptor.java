package com.atshop.security.filter;

import com.atshop.security.entity.User;
import com.atshop.security.entity.AuditLog;
import com.atshop.security.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class AuditLogInterceptor extends HandlerInterceptorAdapter {

    public static final String AUDIT_LOG_ID = "auditLogId";
    @Autowired
    AuditLogRepository auditLogRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        AuditLog auditLog=new AuditLog();
        auditLog.setMethod(request.getMethod());
        auditLog.setPath(request.getRequestURI());

        User user = (User) request.getAttribute("user");
        if (null != user) {
            auditLog.setUsername(user.getUserName());
        }

        auditLogRepository.save(auditLog);
        request.setAttribute(AUDIT_LOG_ID,auditLog.getId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long auditLogId = (Long) request.getAttribute(AUDIT_LOG_ID);
        Optional<AuditLog> auditLog = auditLogRepository.findById(auditLogId);
        AuditLog log = auditLog.get();
        log.setStatus(response.getStatus());
        auditLogRepository.save(log);
    }
}
