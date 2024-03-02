package com.vtxlab.bootcamp.fianlproject.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoDTO;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.fianlproject.infra.RedisHelper;
import com.vtxlab.bootcamp.fianlproject.infra.Syscode;
import com.vtxlab.bootcamp.fianlproject.service.CoingeckoService;
import com.vtxlab.bootcamp.fianlproject.service.RedisCoingeckoService;

@Service
public class RedisCoingeckoServiceImpl implements RedisCoingeckoService{
  
  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CoingeckoService coingeckoService;

  public CoingeckoFinalDTO getCoinMarketData(String currency, List<String> coinId) {
    String key = "crypto:coingecko:coins-markets:" + currency + ":" + coinId;
    CoingeckoFinalDTO coinData = redisHelper.getValue(key);

    if (coinData != null) {
        return coingeckoService.getPrice(currency, coinId);
    } else {
        String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=" + currency + "&ids=" + coinId;
        
        try {
            CoingeckoDTO[] coingeckos = restTemplate.getForObject(url, CoingeckoDTO[].class);
            List<CoingeckoDTO> coingeckoDTOs = Arrays.stream(coingeckos)
                  .filter(coingecko -> coinId.contains(coingecko.getId()))
                  .map(p -> {
                    return CoingeckoDTO.builder()
                      .id(p.getId())
                      .symbol(p.getSymbol())
                      .name(p.getName())
                      .image(p.getImage())
                      .current_price(p.getCurrent_Price())
                      .market_cap(p.getMarket_Cap())
                      .market_cap_rank(p.getMarket_Cap_Rank())
                      .fully_diluted_valuation(p.getFully_Diluted_Valuation())
                      .total_volume(p.getTotal_Volume())
                      .high_24h(p.getHigh_24H())
                      .low_24h(p.getLow_24H())
                      .price_change_24h(p.getPrice_Change_24H())
                      .price_change_percentage_24h(p.getPrice_Change_Percentage_24H())
                      .market_cap_change_24h(p.getMarket_Cap_Change_24H())
                      .market_cap_change_percentage_24h(p.getMarket_Cap_Change_Percentage_24H())
                      .circulating_supply(p.getCirculating_Supply())
                      .total_supply(p.getTotal_Supply())
                      .max_supply(p.getMax_Supply())
                      .ath(p.getAth())
                      .ath_change_percentage(p.getAth_Change_Percentage())
                      .ath_date(p.getAth_Date())
                      .atl(p.getAtl())
                      .atl_change_percentage(p.getAtl_Change_Percentage())
                      .atl_date(p.getAtl_Date())
                      .roi(p.getRoi())
                      .last_updated(p.getLast_Updated())
                      .build();
                }).collect(Collectors.toList());

           
    
                CoingeckoFinalDTO response = CoingeckoFinalDTO.builder()
                  .code(Syscode.OK.getCode())
                  .message(Syscode.OK.getMessage()) 
                  .coingeckoDTO(coingeckoDTOs)
                  .build();
            
                  redisHelper.setValueWithExpiration(key, response, 1, TimeUnit.MINUTES);
                  return response;
        } catch (Exception e) {
            return  CoingeckoFinalDTO.builder()
            .code(Syscode.REST_CLIENT_EXCEPTION.getCode())
            .message(Syscode.REST_CLIENT_EXCEPTION.getMessage()) 
            .coingeckoDTO(null)
            .build();
        }
    }
  }
  
}
