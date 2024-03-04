package com.vtxlab.bootcamp.finnhub.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.finnhub.controller.RedisFinnhubOperation;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;
import com.vtxlab.bootcamp.finnhub.service.RedisFinnhubService;

@RestController
@RequestMapping(value= "/stock/finnhub/api/v2")
public class RedisFinnhubController implements RedisFinnhubOperation{

  @Autowired
  private RedisFinnhubService redisFinnhubService;
  
  @Override
  public FinnhubStockFinalDTO getStockPrice(String symbol) {
    return redisFinnhubService.getStockPrice(symbol);
  }

  @Override
  public FinnhubCompanyProfileFinalDTO getCompanyProfile(String symbol){
    return redisFinnhubService.getCompanyProfile(symbol);
  }
  
}
