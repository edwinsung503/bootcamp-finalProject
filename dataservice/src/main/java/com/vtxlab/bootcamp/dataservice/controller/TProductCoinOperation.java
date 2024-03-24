package com.vtxlab.bootcamp.dataservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;

public interface TProductCoinOperation {
  
  //method 1 : Get
  //http://localhost:8092/data/api/v1/product/coins
  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  TProductProductFinalResponseDTO getCoinData();

  

}
