package com.vtxlab.bootcamp.fianlproject.service;

import org.springframework.http.ResponseEntity;

public interface CoinSerivce {
  
  ResponseEntity<String> getCoinMarketData(String currency, String coinId);
}
