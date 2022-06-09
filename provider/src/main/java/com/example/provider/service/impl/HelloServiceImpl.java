package com.example.provider.service.impl;

import com.example.api.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class HelloServiceImpl implements HelloService {

    @Override
    public String say() {
        return "hello world!";
    }

}
