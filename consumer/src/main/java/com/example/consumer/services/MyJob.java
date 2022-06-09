package com.example.consumer.services;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyJob implements Job {

    private static Logger logger = LoggerFactory.getLogger(MyJob.class);


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        TriggerKey triggerKey = context.getTrigger().getKey();
        logger.info("这里是 Quartz Job 打印对日志，组名：{}，触发器名：{}", triggerKey.getGroup(), triggerKey.getName());
    }
}
