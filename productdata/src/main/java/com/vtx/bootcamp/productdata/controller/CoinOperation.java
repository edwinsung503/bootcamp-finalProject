package com.vtx.bootcamp.productdata.controller;


import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtx.bootcamp.productdata.dto.response.CoinDTO;

public interface CoinOperation {

  //http://localhost:8088/coins/api/v2/add/coins
  @PostMapping(value ="/add/coins")
  ResponseEntity<String> addCoin(@RequestBody List<CoinDTO> coinsId);

}
