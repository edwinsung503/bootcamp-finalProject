package com.vtxlab.bootcamp.finnhub.service.Impl;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;
import com.vtxlab.bootcamp.finnhub.infra.Syscode;
import com.vtxlab.bootcamp.finnhub.service.FinnhubService;

@Service
public class FinnhubServiceImpl implements FinnhubService{
  
  @Autowired
  private RestTemplate restTemplate;

  public FinnhubStockFinalDTO getStockPrice(String symbol){
    String url = "https://finnhub.io/api/v1/quote?symbol="+symbol+"&token=cnhecbhr01qhlslit6mgcnhecbhr01qhlslit6n0";

    FinnhubStockDTO finnhubs = restTemplate.getForObject(url, FinnhubStockDTO.class);
    //FinnhubDTO finnhubs = restTemplate.getForObject(url, FinnhubDTO.class);
    
    FinnhubStockDTO finnhubDTO = FinnhubStockDTO.builder()
            .c(finnhubs.getC())
            .d(finnhubs.getD())
            .dp(finnhubs.getDp())
            .h(finnhubs.getH())
            .l(finnhubs.getL())
            .o(finnhubs.getO())
            .pc(finnhubs.getPc())
            .t(finnhubs.getT())
            .build();
    List<FinnhubStockDTO> finnhubDTOs = Collections.singletonList(finnhubDTO);

      return FinnhubStockFinalDTO.builder()
            .code(Syscode.OK.getCode())
            .message(Syscode.OK.getMessage())
            .finnhubDTOs(finnhubDTOs)
            .build();
  }

  public FinnhubCompanyProfileFinalDTO getStockProfile(String symbol){
    String url = "https://finnhub.io/api/v1/stock/profile2?symbol="+symbol+"&token=cnhecbhr01qhlslit6mgcnhecbhr01qhlslit6n0";

    FinnhubCompanyProfileDTO finnhubCompanyProfiles = restTemplate.getForObject(url, FinnhubCompanyProfileDTO.class);
    
    FinnhubCompanyProfileDTO finnhubCompanyProfileDTO = FinnhubCompanyProfileDTO.builder()
            .country(finnhubCompanyProfiles.getCountry())
            .currency(finnhubCompanyProfiles.getCurrency())
            .estimateCurrency(finnhubCompanyProfiles.getEstimateCurrency())
            .exchange(finnhubCompanyProfiles.getExchange())
            .finnhubIndustry(finnhubCompanyProfiles.getFinnhubIndustry())
            .ipo(finnhubCompanyProfiles.getIpo())
            .logo(finnhubCompanyProfiles.getLogo())
            .marketCapitalization(finnhubCompanyProfiles.getMarketCapitalization())
            .name(finnhubCompanyProfiles.getName())
            .phone(finnhubCompanyProfiles.getPhone())
            .shareOutstanding(finnhubCompanyProfiles.getShareOutstanding())
            .ticker(finnhubCompanyProfiles.getTicker())
            .weburl(finnhubCompanyProfiles.getWeburl())
            .build();
    List<FinnhubCompanyProfileDTO> finnhubCompanyProfileDTOs = Collections.singletonList(finnhubCompanyProfileDTO);

      return FinnhubCompanyProfileFinalDTO.builder()
            .code(Syscode.OK.getCode())
            .message(Syscode.OK.getMessage())
            .finnhubCompanyProfileDTOs(finnhubCompanyProfileDTOs)
            .build();
  }
}
