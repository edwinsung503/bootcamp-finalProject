package com.vtxlab.bootcamp.finnhub.service;

import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;


public interface FinnhubService {
  
  FinnhubStockFinalDTO getStockPrice(String symbol);

  FinnhubCompanyProfileFinalDTO getStockProfile(String symbol);
}
