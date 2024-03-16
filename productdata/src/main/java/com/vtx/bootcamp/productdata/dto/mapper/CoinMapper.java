package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.dto.response.CoinDTO;
import com.vtx.bootcamp.productdata.entity.CoinEntity;

@Component
public class CoinMapper{

  public static CoinEntity map(CoinDTO coinDTO){
    //mapper from rq dto to response dto
    CoinEntity coinEntity = CoinEntity.builder()
      .coin_id(coinDTO.getCoin_id())
      .build();
    return coinEntity;

  }
  
}
