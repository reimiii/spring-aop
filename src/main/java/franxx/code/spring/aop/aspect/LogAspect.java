package franxx.code.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
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
    public void beforeHelloServiceMethod() {
        log.info("before HelloService method");
    }

    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod2() {
        log.info("before HelloService method again");
    }
}
