package com.example.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestResponseLoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingAspect.class);

    @Pointcut("execution(public * com.example.logging.*.*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void logIncomingRequest(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String methodName = joinPoint.getSignature().getName();
        String requestURL = request.getRequestURL().toString();
        String clientIP = request.getRemoteAddr();
        logger.info("Incoming request: Method={}, URL={}, ClientIP={}", methodName, requestURL, clientIP);
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void logOutgoingResponse(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Outgoing response: Method={}, Response={}", methodName, result);
    }
}
