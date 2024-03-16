package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.StockEntity;

@Component
public class StockMapper {

  public static StockEntity map(String stockdto){
    //mapper from rq dto/string to response dto
    StockEntity stockEntity = StockEntity.builder()
      //.stockId(stockdto.getStock_id())
      .stockId(stockdto)
      .build();
    return stockEntity;
  }
}
