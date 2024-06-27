package franxx.code.spring.aop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    private HelloService service;

    @Test
    void callMethod() {
        assertEquals("hello me", service.hello("me"));
        assertEquals("hello me-id", service.hello("me","id"));
        assertEquals("bye me", service.bye("me"));
        service.test();
    }
}