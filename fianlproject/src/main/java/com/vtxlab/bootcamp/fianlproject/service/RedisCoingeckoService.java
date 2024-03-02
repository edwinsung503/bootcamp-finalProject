package com.vtxlab.bootcamp.fianlproject.service;

import java.util.List;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;

public interface RedisCoingeckoService {
  
  CoingeckoFinalDTO  getCoinMarketData(String currency, List<String> coinId);
}
