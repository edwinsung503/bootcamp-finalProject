package com.vtx.bootcamp.productdata.service;

import java.time.LocalTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;
import com.vtx.bootcamp.productdata.entity.StockEntity;

public interface StockService {
  
  void addStock( List<String> stocksId);

  @Transactional
  void deleteStock(List<String> stockId);

  void getStockPrice(List<String> stockId);

  void deleteStockPrice(LocalTime currentTime);

  void getStockProfile(List<String> stockId);

  void deleteStockProfile(LocalTime currentTime);

  void saveStock(FinnhubProfileEntity finnhubProfileEntity,FinnhubQuoteEntity finnhubQuoteEntity,StockEntity stockEntity);
  
  void saveDailyStock(FinnhubQuoteEntity finnhubQuoteEntity,StockEntity stockEntity);
  
}
