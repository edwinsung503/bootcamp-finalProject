package com.vtx.bootcamp.productdata.service;

import java.time.LocalTime;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.vtx.bootcamp.productdata.entity.CryptoCiongeckoEntity;

public interface CoinService {

  void addCoin(List<String> coinsId);

  @Transactional
  void deleteCoin(List<String> coinId);

  void getCoinPrice(List<String> coinId);

  void deleteCoinPrice(LocalTime currentTime);

  void saveCoin(CryptoCiongeckoEntity cryptoCiongeckoEntity);
  
}
