package com.example.consumer.controller;

import com.example.api.service.HelloService;
import com.example.consumer.common.Response;
import com.example.consumer.entry.User;
import com.example.consumer.event.SendEvent;
import com.example.consumer.repository.EsUserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private final static String msg = "hello world!";

    @DubboReference
    HelloService helloService;

    @Resource
    private KafkaTemplate kafkaTemplate;

    @Resource
    private ApplicationEventPublisher publisher;

    @Resource
    private EsUserRepository esUserRepository;


    /**
     * Dubbo RPC 调用 返回 hello 字符串
     * @return
     */
    @GetMapping("/hello")
    public Response<String> hello() {
        String topic = "hello";

        logger.info("这是要入 ES 日志，内容为：{}", msg);
        kafkaTemplate.send(topic, msg);

        publisher.publishEvent(new SendEvent("this.getClass()", msg));
        return Response.success(helloService.say());
    }

    /**
     * 获取用户信息
     * @param name 用户姓名
     * @param info 用户信息
     * @return
     */
    @GetMapping("/getUser")
    public Response<List<User>> getUser(String name, String info) {

        List<User> resultUserList = new ArrayList<>();

        if (name != null && info != null) {
            resultUserList = esUserRepository.findByNameAndInfo(name, info);
        } else if (name != null) {
            resultUserList = esUserRepository.findByName(name);
        } else if (info != null) {
            resultUserList = esUserRepository.findByInfo(info);
        }

        return Response.success(resultUserList);
    }

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public Response<User> saveUser(@Validated @RequestBody User user) {
        return Response.success(esUserRepository.save(user));
    }


    @KafkaListener(groupId = "1", id = "user1", topics = {"hello"})
    public void showMsg(String msg) {
        System.out.println("第一个 partitions 的消费者。");
        System.out.println(msg);
        System.out.println("1111111111");
    }

    @KafkaListener(groupId = "1", id = "user2", topics = {"hello"})
    public void showMsg1(String msg) {
        System.out.println("多于 partitions 的消费者。");
        System.out.println(msg);
        System.out.println("2222222222");
    }

    @KafkaListener(id = "user3", topics = {"hello"})
    public void showMsg2(String msg) {
        System.out.println("消费者 user3");
        System.out.println(msg);
        System.out.println("333333333");
    }

}
