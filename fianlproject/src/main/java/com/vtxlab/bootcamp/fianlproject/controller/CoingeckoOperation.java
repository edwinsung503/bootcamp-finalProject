package com.vtxlab.bootcamp.fianlproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CoingeckoOperation {

  //method 1 : Get
  //http://localhost:8080/crypto/coingecko/api/v1/coins?currency=usd&ids=bitcoin,ethereum
  @GetMapping(value ="/coins")
  @ResponseStatus(value = HttpStatus.OK)
  String getPrice(@RequestParam (value="currency") String currency,
                @RequestParam(value="ids") String id);

}
