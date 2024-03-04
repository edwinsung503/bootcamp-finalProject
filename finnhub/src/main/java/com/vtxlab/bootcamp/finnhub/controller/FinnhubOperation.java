package com.vtxlab.bootcamp.finnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.finnhub.annotation.StockIdCheck;
import com.vtxlab.bootcamp.finnhub.dto.request.StockIdDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;

@Validated
public interface FinnhubOperation {

  //method 1 : Get
  //http://localhost:8091/stock/finnhub/api/v1/quote?symbol=AAPL
  @GetMapping(value ="/quote")
  @ResponseStatus(value = HttpStatus.OK)
  //FinnhubStockFinalDTO getStockPrice(@StockIdCheck @RequestParam (value="symbol",required = true) String symbol);
  FinnhubStockFinalDTO getStockPrice(@StockIdCheck @RequestParam (value="symbol",required = true) StockIdDTO stockIdDTO);
  
  //method 2 : Get
  //http://localhost:8091/stock/finnhub/api/v1/profile2?symbol=AAPL
  @GetMapping(value ="/profile2")
  @ResponseStatus(value = HttpStatus.OK)
  FinnhubCompanyProfileFinalDTO getStockProfile(@StockIdCheck @RequestParam (value="symbol",required = true) StockIdDTO stockIdDTO);
}
