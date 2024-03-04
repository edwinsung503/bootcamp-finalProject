package com.vtxlab.bootcamp.coingecko.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.coingecko.annotation.CoinIdCheck;
import com.vtxlab.bootcamp.coingecko.dto.request.CoinIdDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;

@Validated // 1
public interface CoingeckoOperation {

  //method 1 : Get
  //http://localhost:8080/crypto/coingecko/api/v1/coins?currency=usd&ids=bitcoin,ethereum
  //test : http://localhost:8080/crypto/coingecko/api/v1/coin?currency=usd&ids=bitcoin
  @GetMapping(value ="/coins")
  @ResponseStatus(value = HttpStatus.OK)
  CoingeckoFinalDTO getPrice(@RequestParam (value="currency") String currency,
      @CoinIdCheck @RequestParam(value="ids") List<String> ids);
  
}
