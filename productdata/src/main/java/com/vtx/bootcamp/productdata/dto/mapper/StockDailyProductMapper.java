package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;
import com.vtx.bootcamp.productdata.entity.StockDailyProductEntity;
import com.vtx.bootcamp.productdata.entity.StockEntity;

@Component
public class StockDailyProductMapper {

  public static StockDailyProductEntity map(FinnhubQuoteEntity finnhubQuoteEntity,StockEntity stockEntity){

    StockDailyProductEntity stockDailyProductEntity = StockDailyProductEntity.builder()
          .stockEntities(stockEntity)
          .trade_date(finnhubQuoteEntity.getQuote_date())
          .day_high(finnhubQuoteEntity.getPrice_day_high())
          .day_low(finnhubQuoteEntity.getPrice_day_low())
          .day_open(finnhubQuoteEntity.getPrice_prev_open())
          .day_end(finnhubQuoteEntity.getPrice_prev_close())
          .build();

    return stockDailyProductEntity; 
  }
  
}
