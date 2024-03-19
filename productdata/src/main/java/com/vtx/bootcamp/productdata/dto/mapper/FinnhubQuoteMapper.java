package com.vtx.bootcamp.productdata.dto.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.dto.request.FinnhubQuoteDTO;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;

@Component
public class FinnhubQuoteMapper {


  public static FinnhubQuoteEntity map(FinnhubQuoteDTO finnhubQuoteDTO,String stocks){

    FinnhubQuoteEntity finnhubQuoteEntity = FinnhubQuoteEntity.builder()
          .quote_date(Timestamp.valueOf(LocalDateTime.now()))
          .quote_stock_code(stocks)
          .curr_price(finnhubQuoteDTO.getData().get(0).getC())
          .price_chg(finnhubQuoteDTO.getData().get(0).getD())
          .price_chg_pct(finnhubQuoteDTO.getData().get(0).getDp())
          .price_day_high(finnhubQuoteDTO.getData().get(0).getH())
          .price_day_low(finnhubQuoteDTO.getData().get(0).getL())
          .price_prev_open(finnhubQuoteDTO.getData().get(0).getO())
          .price_prev_close(finnhubQuoteDTO.getData().get(0).getPc())
          .build();

    return finnhubQuoteEntity;
  }
}
