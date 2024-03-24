package com.vtxlab.bootcamp.dataservice.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.dataservice.controller.TProductCoinOperation;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.service.TProductCoinService;

@RestController
@RequestMapping(value = "/data/api/v1/product")
public class TProductCoinController implements TProductCoinOperation{
  
  @Autowired
  private TProductCoinService tProductCoinService;

  @Override
  public TProductProductFinalResponseDTO getCoinData(){
    return tProductCoinService.getCoinData();
  }
}