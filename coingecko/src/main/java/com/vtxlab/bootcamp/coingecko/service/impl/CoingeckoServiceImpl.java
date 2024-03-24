package com.vtxlab.bootcamp.coingecko.service.impl;

import java.lang.module.ResolutionException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.coingecko.infra.Syscode;
import com.vtxlab.bootcamp.coingecko.service.CoingeckoService;

@Service
public class CoingeckoServiceImpl implements CoingeckoService{


  @Autowired
  private RestTemplate restTemplate;
  
  @Override
  public CoingeckoFinalDTO getPrice(String current, List<String> id) throws ResolutionException{

    String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-ZmN8v5NihmGLP3oayyFAPbsS";
    
    CoingeckoDTO[] coingeckos = restTemplate.getForObject(url, CoingeckoDTO[].class);
    
    List<CoingeckoDTO> coingeckoDTOs = Arrays.stream(coingeckos)
            .filter(coingecko -> id.contains(coingecko.getId()))
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

           
    
    return CoingeckoFinalDTO.builder()
          .code(Syscode.OK.getCode())
          .message(Syscode.OK.getMessage()) 
          .coingeckoDTO(coingeckoDTOs)
          .build();
  }

   
}
