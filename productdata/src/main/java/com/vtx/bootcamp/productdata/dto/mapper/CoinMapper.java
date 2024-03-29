package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.CoinEntity;

@Component
public class CoinMapper{
  // CoinDTO -> CoinEntity
  public static CoinEntity map(String coinDTO){
    //mapper from rq dto to response dto
    CoinEntity coinEntity = CoinEntity.builder()
      .coinId(coinDTO)
      .build();
    return coinEntity;

  }
  
}
