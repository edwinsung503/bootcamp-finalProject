package com.vtxlab.bootcamp.fianlproject.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.fianlproject.annotation.CoinIdCheck;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;

//@Validated // 1
public interface CoingeckoOperation {

  //method 1 : Get
  //http://localhost:8080/crypto/coingecko/api/v1/coins?currency=usd&ids=bitcoin,ethereum
  //test : http://localhost:8080/crypto/coingecko/api/v1/coin?currency=usd&ids=bitcoin
  @GetMapping(value ="/coin")
  @ResponseStatus(value = HttpStatus.OK)
  CoingeckoFinalDTO getPrice(@RequestParam (value="currency") String currency,
               @RequestParam(value="ids") List<String> ids);

  //http://localhost:8080/crypto/coingecko/api/v1/coins
  @GetMapping(value = "/coins")
  @ResponseStatus(value = HttpStatus.OK)
  CoingeckoFinalDTO getCoingeckos();

}
