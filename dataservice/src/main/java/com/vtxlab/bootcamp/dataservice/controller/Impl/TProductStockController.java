package com.vtxlab.bootcamp.dataservice.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.dataservice.controller.TProductStockOperation;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.service.TProductStockService;

@RestController
@RequestMapping(value = "/data/api/v1/product")
public class TProductStockController implements TProductStockOperation{

  @Autowired
  private TProductStockService tProductStockService;

  @Override
  public TProductProductFinalResponseDTO getStockData(){
    return tProductStockService.getStockData();
  }
  
}
