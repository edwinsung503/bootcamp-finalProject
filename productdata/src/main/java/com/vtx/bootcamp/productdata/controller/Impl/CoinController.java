package com.vtx.bootcamp.productdata.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtx.bootcamp.productdata.controller.CoinOperation;
import com.vtx.bootcamp.productdata.dto.response.CoinDTO;
import com.vtx.bootcamp.productdata.service.CoinService;

@RestController
@RequestMapping(value="coins/api/v2")
public class CoinController implements CoinOperation{
  
  @Autowired
  private CoinService coinService;

  @Override
  public ResponseEntity<String> addCoin(@RequestBody List<String> coinsId){
    coinService.addCoin(coinsId);
    return new ResponseEntity<>("Coins added successfully", HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteCoin(@RequestParam List<String> coin_id){
    coinService.deleteCoin(coin_id);
    return new ResponseEntity<>("Coins deteled successfully", HttpStatus.CREATED);
  }
}
