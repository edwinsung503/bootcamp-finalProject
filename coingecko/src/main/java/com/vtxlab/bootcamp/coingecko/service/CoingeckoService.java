package com.vtxlab.bootcamp.coingecko.service;

import java.util.List;
import com.vtxlab.bootcamp.coingecko.dto.request.CoinIdDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;

public interface CoingeckoService {
  
  CoingeckoFinalDTO getPrice(String current,  List<String> ids);

  
}
