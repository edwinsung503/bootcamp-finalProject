package com.vtxlab.bootcamp.dataservice.mapping;

import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductResponseDTO;
import com.vtxlab.bootcamp.dataservice.entity.coin.TProductCoinEntity;
import com.vtxlab.bootcamp.dataservice.entity.stock.TProductStockEntity;

@Component
public class TProductCombineMapper {

  public static TProductProductResponseDTO getCoinMap(TProductCoinEntity tProductCoinEntity){

    TProductProductResponseDTO dto = new TProductProductResponseDTO();
    dto.setProductId(tProductCoinEntity.getCoin_id().toString());
    dto.setName(tProductCoinEntity.getName());
    dto.setCurr_price(tProductCoinEntity.getCurr_price());
    dto.setPrice_chg_pct(tProductCoinEntity.getPrice_chg_pct());
    dto.setMarket_cap(tProductCoinEntity.getMarket_cap());
    dto.setLogo(tProductCoinEntity.getLogo());
    return dto;
  }

  public static TProductProductResponseDTO getStockMap(TProductStockEntity tProductStockEntity){
    TProductProductResponseDTO dto = new TProductProductResponseDTO();
    dto.setProductId(tProductStockEntity.getStock_id().toString());
    dto.setName(tProductStockEntity.getName());
    dto.setCurr_price(tProductStockEntity.getCurr_price());
    dto.setPrice_chg_pct(tProductStockEntity.getPrice_chg_pct());
    dto.setMarket_cap(tProductStockEntity.getMarket_cap());
    dto.setLogo(tProductStockEntity.getLogo());
    return dto;
  }
  
}
