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
import com.vtxlab.bootcamp.finnhub.infra.RedisHelper;
import com.vtxlab.bootcamp.finnhub.infra.Syscode;
import com.vtxlab.bootcamp.finnhub.service.FinnhubService;
import com.vtxlab.bootcamp.finnhub.service.RedisFinnhubService;

@Service
public class RedisFinnhubServiceImpl implements RedisFinnhubService{

  @Autowired
  private RedisHelper redisHelper;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private FinnhubService finnhubService;

  public FinnhubStockFinalDTO getStockPrice(String symbol){
    String key = "stock:finnhub:quote:" + symbol;
    FinnhubStockFinalDTO stockData = redisHelper.getValue(key);

    if (stockData != null) {
      return finnhubService.getStockPrice(symbol);
    } else {
      String url = "https://finnhub.io/api/v1/quote?symbol="+symbol+"&token=cnhecbhr01qhlslit6mgcnhecbhr01qhlslit6n0";

      try{
          FinnhubStockDTO finnhubs = restTemplate.getForObject(url, FinnhubStockDTO.class);          //FinnhubDTO finnhubs = restTemplate.getForObject(url, FinnhubDTO.class);
          
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
      } catch (Exception e){
        return FinnhubStockFinalDTO.builder()
            .code(Syscode.REST_CLIENT_EXCEPTION.getCode())
            .message(Syscode.REST_CLIENT_EXCEPTION.getMessage())
            .finnhubDTOs(null)
            .build();
      }
    }
  }
  
  public FinnhubCompanyProfileFinalDTO getCompanyProfile(String symbol){
    String key = "stock:finnhub:profile2:" + symbol;
    FinnhubStockFinalDTO stockData = redisHelper.getValue(key);

    if (stockData != null) {
      return finnhubService.getStockProfile(symbol);
    } else {
      String url = "https://finnhub.io/api/v1/stock/profile2?symbol="+symbol+"&token=cnhecbhr01qhlslit6mgcnhecbhr01qhlslit6n0";

      try{
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
      } catch (Exception e){
        return FinnhubCompanyProfileFinalDTO.builder()
            .code(Syscode.REST_CLIENT_EXCEPTION.getCode())
            .message(Syscode.REST_CLIENT_EXCEPTION.getMessage())
            .finnhubCompanyProfileDTOs(null)
            .build();
      }
    }
  }
}
