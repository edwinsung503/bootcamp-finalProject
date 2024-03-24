package com.vtxlab.bootcamp.dataservice.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;

public interface RedisStockDailyOperation {

  //http://localhost:8092/data/api/v1/product/stock/daily?code=AAPL
  @GetMapping("/stock/daily")
  @ResponseStatus(value = HttpStatus.OK)
  RedisProductFinalResponseDTO getStockDailyData(@RequestParam (value="code") List<String> stocksId);
  
}
