package com.vtxlab.bootcamp.finnhub.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.finnhub.controller.FinnhubOperation;
import com.vtxlab.bootcamp.finnhub.dto.request.StockIdDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;
import com.vtxlab.bootcamp.finnhub.infra.Symbol;
import com.vtxlab.bootcamp.finnhub.infra.Syscode;
import com.vtxlab.bootcamp.finnhub.service.FinnhubService;


@RestController
@RequestMapping(value ="/stock/finnhub/api/v1")
public class FinnhubController implements FinnhubOperation {
  
  @Autowired
  private FinnhubService finnhubService;

  @Override
  public FinnhubStockFinalDTO getStockPrice(StockIdDTO stockIdDTO){
    String symbol = stockIdDTO.getSymbol();
    if (symbol.toUpperCase().equals(Symbol.AAPL.getName())){
      return finnhubService.getStockPrice(symbol);
    }
    return FinnhubStockFinalDTO.builder()
          .code(Syscode.WRONG_INPUT_SYMBOL.getCode())
          .message(Syscode.WRONG_INPUT_SYMBOL.getMessage())
          .finnhubDTOs(null)
          .build();    
  }

  @Override
  public FinnhubCompanyProfileFinalDTO getStockProfile(StockIdDTO stockIdDTO){
    String symbol = stockIdDTO.getSymbol();
    if (symbol.toUpperCase().equals(Symbol.AAPL.getName())){
      return finnhubService.getStockProfile(symbol);
    }
    return FinnhubCompanyProfileFinalDTO.builder()
          .code(Syscode.WRONG_INPUT_SYMBOL.getCode())
          .message(Syscode.WRONG_INPUT_SYMBOL.getMessage())
          .finnhubCompanyProfileDTOs(null)
          .build();    
  }
}
