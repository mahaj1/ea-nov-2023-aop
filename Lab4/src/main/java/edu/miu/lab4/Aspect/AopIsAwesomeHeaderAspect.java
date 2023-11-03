package edu.miu.lab4.Aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AopIsAwesomeHeaderAspect {

    @Before(value = "within(edu.miu.lab4.Service.*) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void checkHeader(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String header = request.getHeader("AOP-IS-AWESOME");

        if (header == null || !header.equals("true")) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or invalid!");
        }
    }
}