package com.example.consumer;

import com.example.consumer.controller.UserController;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

    @Resource
    private UserController userController;

    @Test
    void contextLoads() {
        userController.getUser("小明", null);
        userController.hello();
    }

}
