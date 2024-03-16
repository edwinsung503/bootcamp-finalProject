package com.vtx.bootcamp.productdata.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.vtx.bootcamp.productdata.dto.response.StockDTO;

public interface StockService {
  
  void addStock( List<StockDTO> stocksId);

  @Transactional
  void deleteStock(List<String> stockId);
}
