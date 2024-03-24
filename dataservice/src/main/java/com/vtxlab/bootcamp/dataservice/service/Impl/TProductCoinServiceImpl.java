package com.vtxlab.bootcamp.dataservice.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductResponseDTO;
import com.vtxlab.bootcamp.dataservice.entity.coin.CoinEntity;
import com.vtxlab.bootcamp.dataservice.entity.coin.TProductCoinEntity;
import com.vtxlab.bootcamp.dataservice.infra.Syscode;
import com.vtxlab.bootcamp.dataservice.repository.coin.CoinRespoitory;
import com.vtxlab.bootcamp.dataservice.repository.coin.TProductCoinRespoitory;
import com.vtxlab.bootcamp.dataservice.service.TProductCoinService;

@Service
public class TProductCoinServiceImpl implements TProductCoinService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private TProductCoinRespoitory tProductCoinRespoitory;

  @Autowired
  private CoinRespoitory coinRespoitory;

  @Override
  public TProductProductFinalResponseDTO getCoinData(){
    
    List<TProductCoinEntity> tProductCoinEntities = tProductCoinRespoitory.findAll();
    List<CoinEntity> coinEntities = coinRespoitory.findAll();
    List<TProductProductResponseDTO> tProductProductResponseDTOs = tProductCoinEntities.stream() 
        .map(p-> {
          CoinEntity coinEntity = coinEntities.stream()
            .filter(coin -> coin.getId().equals(p.getCoin_id()))
            .findFirst()
            .orElse(null);

          String coinCode = (coinEntity != null ) ? coinEntity.getCoin_code() : null;

          return TProductProductResponseDTO.builder()
              .productId(coinCode)
              .name(p.getName())
              .curr_price(p.getCurr_price())
              .price_chg_pct(p.getPrice_chg_pct())
              .market_cap(p.getMarket_cap())
              .logo(p.getLogo())
              .build();
        }).collect(Collectors.toList());
        


    return TProductProductFinalResponseDTO.builder()
        .code(Syscode.OK.getCode())
        .message(Syscode.OK.getMessage())
        .tProductCombineResponseDTOs(tProductProductResponseDTOs)
        .build();
  }
  
}
