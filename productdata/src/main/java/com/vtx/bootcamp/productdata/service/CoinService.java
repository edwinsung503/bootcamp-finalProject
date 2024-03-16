package com.vtx.bootcamp.productdata.service;

import java.util.List;
import com.vtx.bootcamp.productdata.dto.response.CoinDTO;

public interface CoinService {

  void addCoin(List<CoinDTO> coinsId);
  
}
