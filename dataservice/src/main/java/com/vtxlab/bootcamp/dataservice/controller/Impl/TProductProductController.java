package com.vtxlab.bootcamp.dataservice.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.dataservice.controller.TProductProductOperation;
import com.vtxlab.bootcamp.dataservice.dto.response.TProductProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.service.TProductProductService;

@RestController
@RequestMapping(value = "/data/api/v1")
public class TProductProductController implements TProductProductOperation{

  @Autowired
  private TProductProductService tProductProductService;

  @Override
  public TProductProductFinalResponseDTO getProductData(){
    return tProductProductService.getProductData();
  }
  
}
