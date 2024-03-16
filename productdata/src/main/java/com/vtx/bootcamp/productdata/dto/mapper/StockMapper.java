package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.dto.response.StockDTO;
import com.vtx.bootcamp.productdata.entity.StockEntity;

@Component
public class StockMapper {

  public static StockEntity map(StockDTO stockdto){
    //mapper from rq dto to response dto
    StockEntity stockEntity = StockEntity.builder()
      .stockId(stockdto.getStock_id())
      .build();
    return stockEntity;

  }
  
}
