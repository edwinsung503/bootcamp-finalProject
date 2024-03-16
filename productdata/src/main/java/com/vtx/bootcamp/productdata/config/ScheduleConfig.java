package com.vtx.bootcamp.productdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

  //Scheduled(fixedDelay = 60000)
  public void fixedDelayTask() throws InterruptedException{
    System.out.println("start fixedDelayTask " + System.currentTimeMillis());

    System.out.println("end fixedDelayTask ");
  }  
}
