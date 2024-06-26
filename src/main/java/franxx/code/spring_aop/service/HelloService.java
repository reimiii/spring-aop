package franxx.code.spring_aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {

    public String hello(String name) {
        log.info("call hello method from {}", HelloService.class);
        return "hello " + name;
    }

    public String bye(String name) {
        log.info("call bye method from {}", HelloService.class);
        return "bye " + name;
    }
}
