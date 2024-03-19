package com.vtx.bootcamp.productdata.service;

import java.time.LocalTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface StockService {
  
  void addStock( List<String> stocksId);

  @Transactional
  void deleteStock(List<String> stockId);

  void getStockPrice(List<String> stockId);

  void deleteStockPrice(LocalTime currentTime);

  void getStockProfile(List<String> stockId);

  void deleteStockProfile(LocalTime currentTime);
  
}
