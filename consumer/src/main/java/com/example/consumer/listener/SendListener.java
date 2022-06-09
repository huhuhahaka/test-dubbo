package com.example.consumer.listener;

import com.example.consumer.event.SendEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SendListener implements ApplicationListener<SendEvent> {

    @Override
    public void onApplicationEvent(SendEvent event) {
        System.out.println("监听到了事件 " + SendEvent.class.getName() + " 内容 -> "  + event.getMsg());
    }
}
