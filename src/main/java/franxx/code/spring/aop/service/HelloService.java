package franxx.code.spring.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {

    public String hello(String name) {
        log.info("call hello method from {}", HelloService.class);
        return "hello " + name;
    }

    public String hello(String name, String id) {
        log.info("call hello method two from {}", HelloService.class);
        return "hello " + name + "-" + id;
    }

    public String bye(String name) {
        log.info("call bye method from {}", HelloService.class);
        return "bye " + name;
    }

    public void test() {
        log.info("call test method from {}", HelloService.class);
    }
}
