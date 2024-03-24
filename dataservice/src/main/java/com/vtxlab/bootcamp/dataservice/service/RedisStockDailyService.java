package com.vtxlab.bootcamp.dataservice.service;

import java.util.List;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;

public interface RedisStockDailyService {

  RedisProductFinalResponseDTO getStockDailyData(List<String> stocksId);
  
}
