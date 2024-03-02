package com.vtxlab.bootcamp.fianlproject.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.fianlproject.controller.RedisCoingeckoOperation;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.fianlproject.service.RedisCoingeckoService;

@RestController
@RequestMapping(value= "/crypto/coingecko/api/v2")
public class RedisRedisCoingeckoController implements RedisCoingeckoOperation {

  @Autowired
  private RedisCoingeckoService redisCoingeckoService;

  @Override
  public CoingeckoFinalDTO getCoinMarketData(String currency, List<String> coinId) {
        return redisCoingeckoService.getCoinMarketData(currency,coinId);
    }
  
}
