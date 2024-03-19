package com.vtx.bootcamp.productdata.dto.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.dto.request.FinnhubProfileDTO;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;

@Component
public class FinnhubProfileMapper {

  public static FinnhubProfileEntity map(FinnhubProfileDTO finnhubProfileDTO,String stocks){
    
    FinnhubProfileEntity finnhubProfileEntity = FinnhubProfileEntity.builder()
            .quote_date(Timestamp.valueOf(LocalDateTime.now()))
            .quote_stock_code(stocks)
            .country(finnhubProfileDTO.getData().get(0).getCountry())
            .currency(finnhubProfileDTO.getData().get(0).getCurrency())
            .estimateCurrency(finnhubProfileDTO.getData().get(0).getEstimateCurrency())
            .exchange(finnhubProfileDTO.getData().get(0).getExchange())
            .finnhubIndustry(finnhubProfileDTO.getData().get(0).getFinnhubIndustry())
            .ipo(finnhubProfileDTO.getData().get(0).getIpo())
            .logo(finnhubProfileDTO.getData().get(0).getLogo())
            .marketCapitalization(finnhubProfileDTO.getData().get(0).getMarketCapitalization())
            .name(finnhubProfileDTO.getData().get(0).getName())
            .phone(finnhubProfileDTO.getData().get(0).getPhone())
            .shareOutstanding(finnhubProfileDTO.getData().get(0).getShareOutstanding())
            .ticker(finnhubProfileDTO.getData().get(0).getTicker())
            .weburl(finnhubProfileDTO.getData().get(0).getWeburl())
            .build();


    return finnhubProfileEntity;
  }
  
}
