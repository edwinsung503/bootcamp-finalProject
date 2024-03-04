package com.vtxlab.bootcamp.coingecko.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.coingecko.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.coingecko.dto.request.CoinIdDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.coingecko.infra.Currency;
import com.vtxlab.bootcamp.coingecko.infra.Syscode;
import com.vtxlab.bootcamp.coingecko.service.CoingeckoService;

@RestController
@RequestMapping(value= "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {

  @Autowired
  private CoingeckoService coingeckoService;

  @Override
  //selected coinType
  public CoingeckoFinalDTO getPrice(String currency,  List<String> ids){
    //List<String> id = coinIdDTO.get(0);
    if (currency.equals(Currency.USD.getName())){
      return coingeckoService.getPrice(currency, ids);
    }
    return CoingeckoFinalDTO.builder()
            .code(Syscode.WRONG_CURRENCY.getCode())
            .message(Syscode.WRONG_CURRENCY.getMessage()) 
            .coingeckoDTO(null)
            .build();
  }
}
