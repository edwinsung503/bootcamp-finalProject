package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.entity.CoinProductEntity;
import com.vtx.bootcamp.productdata.entity.CryptoCiongeckoEntity;

@Component
public class CoinProductMapper {

  public static CoinProductEntity map(CryptoCiongeckoEntity cryptoCiongeckoEntity){
    
    CoinProductEntity coinProductEntity = CoinProductEntity.builder()
          .coin_id(cryptoCiongeckoEntity.getId())
          .name(cryptoCiongeckoEntity.getName())
          .curr_price(cryptoCiongeckoEntity.getCurr_price())
          .price_chg_pct(cryptoCiongeckoEntity.getPrice_change_pct_24h())
          .market_cap(cryptoCiongeckoEntity.getMarket_cap())
          .logo(cryptoCiongeckoEntity.getImage())
          .build();

      return coinProductEntity;
  }
  
}
