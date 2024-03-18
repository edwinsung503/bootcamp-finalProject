package com.vtx.bootcamp.productdata.config.appStartRunner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.repository.StockJpaRepository;
import com.vtx.bootcamp.productdata.service.Impl.StockServiceImpl;

@Component
@Order(2)
public class AppStartRunnerStock implements CommandLineRunner{

  @Autowired
  private StockJpaRepository stockJpaRepository;

  @Autowired
  private StockServiceImpl stockServiceImpl;
  @Override
  public void run(String ... args){
    System.out.println("Check StockList - App Start Process.");

    List<StockEntity> stockEntities = stockJpaRepository.findAll();
    boolean empty = stockEntities.isEmpty();
    boolean hasAAPL = false;
    for (StockEntity stockEntity: stockEntities){
      if(stockEntity.getStockId().equals("AAPL")){
        hasAAPL = true;
      }
    }
    if (empty == true || hasAAPL == false){
      System.out.println("no AAPL or no stockId");
      List<String> stocksId = new ArrayList<>();
      stocksId.add("AAPL");
      stockServiceImpl.addStock(stocksId);
    }
    System.out.println("StockList Fulfiled");
  }
  
}
