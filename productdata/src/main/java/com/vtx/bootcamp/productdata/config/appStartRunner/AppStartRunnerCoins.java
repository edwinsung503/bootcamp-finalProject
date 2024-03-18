package com.vtx.bootcamp.productdata.config.appStartRunner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.service.Impl.CoinServiceImpl;

@Component
@Order(1)
public class AppStartRunnerCoins implements CommandLineRunner {
  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Autowired
  private CoinServiceImpl coinServiceImpl;

  @Override
  public void run(String ... args){
    System.out.println("Check CoinList - App Start Process.");

    List<CoinEntity> coinEntities = coinJpaRepository.findAll();
    boolean empty = coinEntities.isEmpty();//empty->true
    boolean hasBitcoin = false;
    for (CoinEntity coinEntity : coinEntities){
      if (coinEntity.getCoinId().equals("bitcoin")){
        hasBitcoin = true;
      }
    }
    if (empty == true || hasBitcoin == false){
      System.out.println("no bitcoin or no coinId");
      List<String> coinsId = new ArrayList<>();
      coinsId.add("bitcoin");
      coinServiceImpl.addCoin(coinsId);
    } 
    System.out.println("CoinList Fulfiled");
  }
}
