package com.vtxlab.bootcamp.dataservice.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.dataservice.controller.RedisStockDailyOperation;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.service.RedisStockDailyService;

@RestController
@RequestMapping(value = "/data/api/v1/product")
public class RedisStockDailyController implements RedisStockDailyOperation{

  @Autowired
  private RedisStockDailyService redisStockDailyService;

  public RedisProductFinalResponseDTO getStockDailyData(List<String> stocksId){
    return redisStockDailyService.getStockDailyData(stocksId);
  }
  
}
