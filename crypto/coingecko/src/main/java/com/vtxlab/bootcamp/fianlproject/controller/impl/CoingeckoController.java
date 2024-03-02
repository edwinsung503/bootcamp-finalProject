package com.vtxlab.bootcamp.fianlproject.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.fianlproject.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.fianlproject.infra.Currency;
import com.vtxlab.bootcamp.fianlproject.infra.Syscode;
import com.vtxlab.bootcamp.fianlproject.service.CoingeckoService;

@RestController
@RequestMapping(value= "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {

  @Autowired
  private CoingeckoService coingeckoService;

  @Override
  //selected coinType
  public CoingeckoFinalDTO getPrice(String currency, List<String> id){
    if (currency.equals(Currency.USD.getName())){
      return coingeckoService.getPrice(currency, id);
    }
    return CoingeckoFinalDTO.builder()
            .code(Syscode.WRONG_CURRENCY.getCode())
            .message(Syscode.WRONG_CURRENCY.getMessage()) 
            .coingeckoDTO(null)
            .build();
  }

  
  
}
