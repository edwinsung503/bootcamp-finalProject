package com.vtx.bootcamp.productdata.config;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.service.Impl.CoinServiceImpl;

@Configuration
@EnableScheduling
public class ScheduleConfig {

  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Autowired
  private CoinServiceImpl coinServiceImpl;

  
  @Scheduled(fixedDelay = 600000) // 600000 -> 10mins
  public void fixedDelayTaskCoins() throws InterruptedException{
    System.out.println("start fixedDelayTask: Coins");
    List<CoinEntity> coin = coinJpaRepository.findAll();
    List<String> coinList = new ArrayList<>();
    if (!coin.isEmpty()){
      for (CoinEntity c : coin){
        coinList.add(c.getCoinId()) ;
      }
    }
    System.out.println(coinList.toString());
    LocalTime currentTime = LocalTime.now();
    coinServiceImpl.deleteCoinPrice(currentTime);
    coinServiceImpl.getCoinPrice(coinList);
    System.out.println("end fixedDelayTask: Coins");
  }  
}
