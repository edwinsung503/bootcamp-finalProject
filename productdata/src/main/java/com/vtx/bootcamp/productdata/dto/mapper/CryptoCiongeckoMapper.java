package com.vtx.bootcamp.productdata.dto.mapper;

import org.springframework.stereotype.Component;
import com.vtx.bootcamp.productdata.dto.request.CryptoCoingeckoDTO;
import com.vtx.bootcamp.productdata.entity.CryptoCiongeckoEntity;

@Component
public class CryptoCiongeckoMapper {

  
  public static CryptoCiongeckoEntity map(CryptoCoingeckoDTO cryptoCoingeckoDTO,String coins){

    CryptoCiongeckoEntity ciongeckoEntity = CryptoCiongeckoEntity.builder()
                .quote_date(cryptoCoingeckoDTO.getData().get(0).getLastUpdated())
                .qutoe_coin_code(cryptoCoingeckoDTO.getData().get(0).getSymbol())
                .qutoe_currency(coins)
                .name(cryptoCoingeckoDTO.getData().get(0).getName())
                .image(cryptoCoingeckoDTO.getData().get(0).getImage())
                .curr_price(cryptoCoingeckoDTO.getData().get(0).getCurrentPrice())
                .market_cap(cryptoCoingeckoDTO.getData().get(0).getMarketCap())
                .full_diluted_valuation(cryptoCoingeckoDTO.getData().get(0).getFullyDilutedValuation())
                .total_voulume(cryptoCoingeckoDTO.getData().get(0).getTotalVolume())
                .high_24(cryptoCoingeckoDTO.getData().get(0).getHigh24h())
                .low_24h(cryptoCoingeckoDTO.getData().get(0).getLow24h())
                .price_change_24h(cryptoCoingeckoDTO.getData().get(0).getPriceChange24h())
                .price_change_pct_24h(cryptoCoingeckoDTO.getData().get(0).getPriceChangePercentage24h())
                .market_cap_change_24h(cryptoCoingeckoDTO.getData().get(0).getMarketCapChange24h())
                .market_cap_change_pct_24h(cryptoCoingeckoDTO.getData().get(0).getMarketCapChangePercentage24h())
                .circulating_supply(cryptoCoingeckoDTO.getData().get(0).getCirculatingSupply())
                .total_supply(cryptoCoingeckoDTO.getData().get(0).getTotalSupply())
                .max_supply(cryptoCoingeckoDTO.getData().get(0).getMaxSupply())
                .ath(cryptoCoingeckoDTO.getData().get(0).getAth())
                .ath_change_percentage(cryptoCoingeckoDTO.getData().get(0).getAthChangePercentage())
                .ath_date(cryptoCoingeckoDTO.getData().get(0).getAthDate())
                .atl(cryptoCoingeckoDTO.getData().get(0).getAtl())
                .atl_change_percentage(cryptoCoingeckoDTO.getData().get(0).getAtlChangePercentage())
                .atl_date(cryptoCoingeckoDTO.getData().get(0).getAtlDate())
                .build();
      return ciongeckoEntity;
  }
  
}
