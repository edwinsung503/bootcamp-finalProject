package com.vtx.bootcamp.productdata.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface StockService {
  
  void addStock( List<String> stocksId);

  @Transactional
  void deleteStock(List<String> stockId);
}
