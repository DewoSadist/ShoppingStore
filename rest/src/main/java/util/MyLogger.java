/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {

    Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Handle to the log file
     */
    public MyLogger() {
    }
    
    @Before("execution(* org.my.package.*.*(..))")
    public void logMethodAccessBefore(JoinPoint joinPoint) {
        log.info("***** Starting: " + joinPoint.getSignature().getName() + " *****");
    }

    @AfterReturning("execution(* org.my.package.*.*(..))")
    public void logMethodAccessAfter(JoinPoint joinPoint) {
        log.info("***** Completed: " + joinPoint.getSignature().getName() + " *****");
        log.info("***** returned ");
    }

    
}
