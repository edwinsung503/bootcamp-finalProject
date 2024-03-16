package com.vtx.bootcamp.productdata.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface CoinService {

  void addCoin(List<String> coinsId);

  @Transactional
  void deleteCoin(List<String> coinId);
  
}
