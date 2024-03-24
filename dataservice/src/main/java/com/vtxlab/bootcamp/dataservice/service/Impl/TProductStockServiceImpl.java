package com.vtxlab.bootcamp.dataservice.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductResponseDTO;
import com.vtxlab.bootcamp.dataservice.entity.stock.StockEntity;
import com.vtxlab.bootcamp.dataservice.entity.stock.TProductStockEntity;
import com.vtxlab.bootcamp.dataservice.infra.Syscode;
import com.vtxlab.bootcamp.dataservice.repository.stock.StockRespoitory;
import com.vtxlab.bootcamp.dataservice.repository.stock.TProductStockRespoitory;
import com.vtxlab.bootcamp.dataservice.service.TProductStockService;

@Service
public class TProductStockServiceImpl implements TProductStockService{

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private TProductStockRespoitory tProductStockRespoitory;

  @Autowired
  private StockRespoitory stockRespoitory;

  @Override
  public TProductProductFinalResponseDTO getStockData(){

    List<TProductStockEntity> tProductStockEntities = tProductStockRespoitory.findAll();
    List<StockEntity> stockEntities = stockRespoitory.findAll();

    List<TProductProductResponseDTO> tProductProductResponseDTOs = tProductStockEntities.stream()
          .map(p -> {
            StockEntity stockEntity = stockEntities.stream()
              .filter(stock -> stock.getId().equals(p.getStock_id()))
              .findFirst()
              .orElse(null);

            String stockCode = (stockEntity != null) ? stockEntity.getStock_code() : null;

            return TProductProductResponseDTO.builder()
                .productId(stockCode)
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
