package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.entity.StockProductEntity;

@Component
public class StockProductMapper {

  public static StockProductEntity map(FinnhubProfileEntity finnhubProfileEntity ,FinnhubQuoteEntity finnhubQuoteEntity, StockEntity stockEntity){

    StockProductEntity stockProductEntity = StockProductEntity.builder()
            .stockEntity(stockEntity)
            .name(finnhubProfileEntity.getName())
            .curr_price(finnhubQuoteEntity.getCurr_price())
            .price_chg_pct(finnhubQuoteEntity.getPrice_chg_pct())
            .market_cap(finnhubProfileEntity.getMarketCapitalization())
            .logo(finnhubProfileEntity.getLogo())
            .build();
      return stockProductEntity;
  }
  
}
