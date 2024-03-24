package com.vtxlab.bootcamp.dataservice.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductResponseDTO;
import com.vtxlab.bootcamp.dataservice.infra.Syscode;
import com.vtxlab.bootcamp.dataservice.service.TProductProductService;

@Service
public class TProductProductServiceImpl implements TProductProductService{

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private TProductCoinServiceImpl tProductCoinServiceImpl;

  @Autowired
  private TProductStockServiceImpl tProductStockServiceImpl;

  @Override
  public TProductProductFinalResponseDTO getProductData(){

    List<TProductProductResponseDTO> tProductCoinResponseDTOs = tProductCoinServiceImpl.getCoinData().getTProductCombineResponseDTOs();
    List<TProductProductResponseDTO> tProductStockResponseDTOs =  tProductStockServiceImpl.getStockData().getTProductCombineResponseDTOs();
    
    List<TProductProductResponseDTO> products = new ArrayList<>();
    
    for (TProductProductResponseDTO coinEntity: tProductCoinResponseDTOs) {
      products.add(coinEntity);
    }

    for (TProductProductResponseDTO stockEntity : tProductStockResponseDTOs){
      products.add(stockEntity);
    }
    
    return TProductProductFinalResponseDTO.builder()
      .code(Syscode.OK.getCode())
      .message(Syscode.OK.getMessage())
      .tProductCombineResponseDTOs(products)
      .build();

  }
  
}
