package com.vtxlab.bootcamp.finnhub;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.finnhub.controller.Impl.FinnhubController;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;
import com.vtxlab.bootcamp.finnhub.service.FinnhubService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(FinnhubController.class)
public class FinnhubControllerTest {

  @MockBean
  private FinnhubService finnhubService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testGetStockPrice() throws Exception{
    
    String symbols = "AAPL";
    FinnhubStockFinalDTO finnhubStockFinalDTO = new FinnhubStockFinalDTO();
    finnhubStockFinalDTO.setCode("000000");
    finnhubStockFinalDTO.setMessage("OK.");
    List<FinnhubStockDTO> finnhubStockDTOList = new ArrayList<>();
    FinnhubStockDTO finnhubStockDTO = new FinnhubStockDTO();
    finnhubStockDTO.setC("179.66");
    finnhubStockDTO.setD("-1.09");
    finnhubStockDTO.setDp("-0.603");
    finnhubStockDTO.setH("180.53");
    finnhubStockDTO.setL("177.38");
    finnhubStockDTO.setO("179.55");
    finnhubStockDTO.setPc("180.75");
    finnhubStockDTO.setT("1709251200");
    
    finnhubStockDTOList.add(finnhubStockDTO);
    
    finnhubStockFinalDTO.setFinnhubDTOs(finnhubStockDTOList);

    Mockito.when(finnhubService.getStockPrice(symbols)).thenReturn(finnhubStockFinalDTO);

    mockMvc.perform(get("/stock/finnhub/api/v1/quote")
            .param("symbol", symbols))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.code").value("000000"))
            .andExpect(jsonPath("$.message").value("OK."))
            .andExpect(jsonPath("$.data[0].c").value("179.66"))
            .andExpect(jsonPath("$.data[0].d").value("-1.09"))
            .andExpect(jsonPath("$.data[0].dp").value("-0.603"))
            .andExpect(jsonPath("$.data[0].h").value("180.53"))
            .andExpect(jsonPath("$.data[0].l").value("177.38"))
            .andExpect(jsonPath("$.data[0].o").value("179.55"))
            .andExpect(jsonPath("$.data[0].pc").value("180.75"))
            .andExpect(jsonPath("$.data[0].t").value("1709251200"))
            .andDo(print());
  }

  @Test
  public void testStockProfile() throws Exception{

      String symbols = "AAPL";
      FinnhubCompanyProfileFinalDTO finnhubCompanyProfileFinalDTO = new FinnhubCompanyProfileFinalDTO();
      finnhubCompanyProfileFinalDTO.setCode("000000");
      finnhubCompanyProfileFinalDTO.setMessage("OK.");
      List<FinnhubCompanyProfileDTO> finnhubCompanyProfileDTOList = new ArrayList<>();
      FinnhubCompanyProfileDTO finnhubCompanyProfileDTO = new FinnhubCompanyProfileDTO();
      finnhubCompanyProfileDTO.setCountry("US");
      finnhubCompanyProfileDTO.setCurrency("USD");
      finnhubCompanyProfileDTO.setEstimateCurrency("USD");
      finnhubCompanyProfileDTO.setExchange("NASDAQ NMS - GLOBAL MARKET");
      finnhubCompanyProfileDTO.setFinnhubIndustry("Technology");
      finnhubCompanyProfileDTO.setIpo("1980-12-12");
      finnhubCompanyProfileDTO.setLogo("https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg");
      finnhubCompanyProfileDTO.setMarketCapitalization(2774288.3151952810);
      finnhubCompanyProfileDTO.setName("Apple Inc");
      finnhubCompanyProfileDTO.setPhone("14089961010");
      finnhubCompanyProfileDTO.setShareOutstanding(15441.88);
      finnhubCompanyProfileDTO.setTicker("AAPL");
      finnhubCompanyProfileDTO.setWeburl("https://www.apple.com/");

      finnhubCompanyProfileDTOList.add(finnhubCompanyProfileDTO);

      finnhubCompanyProfileFinalDTO.setFinnhubCompanyProfileDTOs(finnhubCompanyProfileDTOList);

      Mockito.when(finnhubService.getStockProfile(symbols)).thenReturn(finnhubCompanyProfileFinalDTO);

      mockMvc.perform(get("/stock/finnhub/api/v1/profile2")
          .param("symbol", symbols))
          .andExpect(status().isOk())
          .andExpect(content().contentType(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$.code").value("000000"))
          .andExpect(jsonPath("$.message").value("OK."))
          .andExpect(jsonPath("$.data[0].country").value("US"))
          .andExpect(jsonPath("$.data[0].currency").value("USD"))
          .andExpect(jsonPath("$.data[0].estimateCurrency").value("USD"))
          .andExpect(jsonPath("$.data[0].exchange").value("NASDAQ NMS - GLOBAL MARKET"))
          .andExpect(jsonPath("$.data[0].finnhubIndustry").value("Technology"))
          .andExpect(jsonPath("$.data[0].ipo").value("1980-12-12"))
          .andExpect(jsonPath("$.data[0].logo").value("https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.svg"))
          .andExpect(jsonPath("$.data[0].marketCapitalization").value(2774288.3151952810))
          .andExpect(jsonPath("$.data[0].name").value("Apple Inc"))
          .andExpect(jsonPath("$.data[0].phone").value("14089961010"))
          .andExpect(jsonPath("$.data[0].shareOutstanding").value(15441.88))
          .andExpect(jsonPath("$.data[0].ticker").value("AAPL"))
          .andExpect(jsonPath("$.data[0].weburl").value("https://www.apple.com/"))
          .andDo(print());
  }
}
