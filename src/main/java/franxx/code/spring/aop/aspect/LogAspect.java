package franxx.code.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("target(franxx.code.spring.aop.service.HelloService)")
    public void helloServiceMethod() {
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint) {
        String nameClass = joinPoint.getTarget().getClass().getName();
        String nameMethod = joinPoint.getSignature().getName();
        log.info("before " + nameClass + "." + nameMethod + "()");
    }

    @Around("helloServiceMethod()")
    public Object aroundHelloService(ProceedingJoinPoint joinPoint) throws Throwable {
        String nameClass = joinPoint.getTarget().getClass().getName();
        String nameMethod = joinPoint.getSignature().getName();
        try {
            log.info("around before " + nameClass + "." + nameMethod + "()");
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable) {
            log.info("around throw " + nameClass + "." + nameMethod + "()");
            throw throwable;
        } finally {
            log.info("around finally " + nameClass + "." + nameMethod + "()");
        }
    }

    @Pointcut("execution(* franxx.code.spring.aop.service.HelloService.*(java.lang.String))")
    public void pointcutHelloServiceParam() {
    }

    @Before("pointcutHelloServiceParam()")
    public void logStringParam(JoinPoint joinPoint) {
        String value = (String) joinPoint.getArgs()[0];
        log.info("execute method with param value: {}", value);
    }
}
