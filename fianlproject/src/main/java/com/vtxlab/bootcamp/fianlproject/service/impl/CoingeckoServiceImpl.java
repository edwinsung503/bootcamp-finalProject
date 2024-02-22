package com.vtxlab.bootcamp.fianlproject.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.fianlproject.dto.request.Coingeckos;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoDTO;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.fianlproject.infra.Syscode;
import com.vtxlab.bootcamp.fianlproject.service.CoingeckoService;

@Service
public class CoingeckoServiceImpl implements CoingeckoService{

  @Autowired
  private RestTemplate restTemplate;
  
  @Override
  public CoingeckoFinalDTO getPrice(String current, List<String> id){
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
                .current_price(p.getCurrent_price())
                .market_cap(p.getMarket_cap())
                .fully_diluted_valuation(p.getFully_diluted_valuation())
                .total_volume(p.getTotal_volume())
                .high_24h(p.getHigh_24h())
                .low_24h(p.getLow_24h())
                .price_change_24h(p.getPrice_change_24h())
                .price_change_percentage_24h(p.getPrice_change_percentage_24h())
                .market_cap_change_24h(p.getMarket_cap_change_24h())
                .market_cap_change_percentage_24h(p.getMarket_cap_change_percentage_24h())
                .circulating_supply(p.getCirculating_supply())
                .total_supply(p.getTotal_supply())
                .max_supply(p.getMax_supply())
                .ath(p.getAth())
                .ath_change_percentage(p.getAth_change_percentage())
                .ath_date(p.getAth_date())
                .atl(p.getAtl())
                .atl_change_percentage(p.getAtl_change_percentage())
                .atl_date(p.getAtl_date())
                .roi(p.getRoi())
                .last_updated(p.getLast_updated())
                .build();
           }).collect(Collectors.toList());

    return CoingeckoFinalDTO.builder()
          .code(Syscode.OK.getCode()) // replace with actual code
          .message(Syscode.OK.getMessage()) // replace with actual message
          .coingeckoDTO(coingeckoDTOs)
          .build();

   
  }

  @Override
  public CoingeckoFinalDTO getCoingeckos(){
    String url = "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&x_cg_demo_api_key=CG-ZmN8v5NihmGLP3oayyFAPbsS";

    Coingeckos[] coingeckos = restTemplate.getForObject(url, Coingeckos[].class);

    List<CoingeckoDTO> coingeckoDTOs = Arrays.stream(coingeckos)
           .map(p -> {
              return CoingeckoDTO.builder()
                .id(p.getId())
                .symbol(p.getSymbol())
                .name(p.getName())
                .image(p.getImage())
                .current_price(p.getCurrent_price())
                .market_cap(p.getMarket_cap())
                .fully_diluted_valuation(p.getFully_diluted_valuation())
                .total_volume(p.getTotal_volume())
                .high_24h(p.getHigh_24h())
                .low_24h(p.getLow_24h())
                .price_change_24h(p.getPrice_change_24h())
                .price_change_percentage_24h(p.getPrice_change_percentage_24h())
                .market_cap_change_24h(p.getMarket_cap_change_24h())
                .market_cap_change_percentage_24h(p.getMarket_cap_change_percentage_24h())
                .circulating_supply(p.getCirculating_supply())
                .total_supply(p.getTotal_supply())
                .max_supply(p.getMax_supply())
                .ath(p.getAth())
                .ath_change_percentage(p.getAth_change_percentage())
                .ath_date(p.getAth_date())
                .atl(p.getAtl())
                .atl_change_percentage(p.getAtl_change_percentage())
                .atl_date(p.getAtl_date())
                .roi(p.getRoi())
                .last_updated(p.getLast_updated())
                .build();
           }).collect(Collectors.toList());

    return CoingeckoFinalDTO.builder()
        .code(Syscode.OK.getCode()) // replace with actual code
        .message(Syscode.OK.getMessage()) // replace with actual message
        .coingeckoDTO(coingeckoDTOs)
        .build();
  }
}
