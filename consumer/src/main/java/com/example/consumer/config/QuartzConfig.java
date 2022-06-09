package com.example.consumer.config;

import com.example.consumer.services.MyJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        //这里传入MyFirstJob业务类。
        return JobBuilder.newJob(MyJob.class).storeDurably().build();
    }

    //定时调用
    @Bean
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("触发器1", "组1")
                //每 5 秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?*"))
                .forJob(jobDetail()) //这个定时任务要执行的是哪个调度器
                .build();
    }


}
