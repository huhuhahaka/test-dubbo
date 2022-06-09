package com.example.consumer.event;

import org.springframework.context.ApplicationEvent;


public class SendEvent extends ApplicationEvent {

    private String msg;

    public SendEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
