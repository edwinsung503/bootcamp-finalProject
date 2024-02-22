package com.vtxlab.bootcamp.fianlproject.service;

import java.util.List;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;

public interface CoingeckoService {
  
  CoingeckoFinalDTO getPrice(String current, List<String> id);

  CoingeckoFinalDTO getCoingeckos();
}
