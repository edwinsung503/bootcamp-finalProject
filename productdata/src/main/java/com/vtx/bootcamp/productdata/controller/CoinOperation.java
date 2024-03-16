package com.vtx.bootcamp.productdata.controller;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CoinOperation {

  //http://localhost:8088/coins/api/v2/add/coins?coin_id=ethereum
  @PostMapping(value ="/add/coins")
  ResponseEntity<String> addCoin(@RequestParam (value="coin_id")  List<String> coinsId);

  //http://localhost:8088/stocks/api/v2/delete/coins?coin_id=ethereum
  @GetMapping(value="/delete/coins")
  ResponseEntity<String> deleteCoin(@RequestParam(value="coin_id") List<String> coin_id);

}
