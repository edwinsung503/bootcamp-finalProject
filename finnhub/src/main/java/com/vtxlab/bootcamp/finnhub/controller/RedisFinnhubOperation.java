package com.vtxlab.bootcamp.finnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;

public interface RedisFinnhubOperation {
  
  @GetMapping("/quote/{symbol}")
  @ResponseStatus(value = HttpStatus.OK)
  FinnhubStockFinalDTO getStockPrice(@PathVariable (value="symbol",required = true) String symbol);

  @GetMapping("/profile2/{symbol}")
  @ResponseStatus(value = HttpStatus.OK)
  FinnhubCompanyProfileFinalDTO getCompanyProfile(@PathVariable (value="symbol",required = true) String symbol);
}
