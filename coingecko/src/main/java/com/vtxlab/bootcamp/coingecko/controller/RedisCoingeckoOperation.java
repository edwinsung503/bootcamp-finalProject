package com.vtxlab.bootcamp.coingecko.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;

public interface RedisCoingeckoOperation {
  
  //http://localhost:8090/crypto/coingecko/api/v1/usd/bitcoin
  @GetMapping("/{currency}/{coinId}")
  @ResponseStatus(value = HttpStatus.OK)
  CoingeckoFinalDTO getCoinMarketData(@PathVariable  (value="currency") String currency, 
                                          @PathVariable  (value="coinId") List<String> coinId);
  
}
