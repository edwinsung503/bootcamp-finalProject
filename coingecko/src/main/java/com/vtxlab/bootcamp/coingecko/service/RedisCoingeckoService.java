package com.vtxlab.bootcamp.coingecko.service;

import java.util.List;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;

public interface RedisCoingeckoService {
  
  CoingeckoFinalDTO  getCoinMarketData(String currency, List<String> coinId);
}
