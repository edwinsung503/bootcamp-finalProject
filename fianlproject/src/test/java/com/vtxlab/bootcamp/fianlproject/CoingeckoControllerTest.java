package com.vtxlab.bootcamp.fianlproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.fianlproject.controller.impl.CoingeckoController;
import com.vtxlab.bootcamp.fianlproject.dto.request.Coingeckos;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoDTO;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.fianlproject.service.CoingeckoService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(CoingeckoController.class)
public class CoingeckoControllerTest {

    @MockBean
    private CoingeckoService coingeckoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPrice() throws Exception {
        
        String currency = "usd";
        List<String> ids = new ArrayList<>();
        ids.add("bitcoin");
        ids.add("ethereum");
        CoingeckoFinalDTO coingeckoFinalDTO = new CoingeckoFinalDTO();
        coingeckoFinalDTO.setCode("000000");
        coingeckoFinalDTO.setMessage("OK");
        List<CoingeckoDTO> coingeckoDTOList = new ArrayList<>();
        CoingeckoDTO coingeckoDTO = new CoingeckoDTO();
        coingeckoDTO.setId("bitcoin");
        coingeckoDTO.setSymbol("btc");
        coingeckoDTO.setName("Bitcoin");
        coingeckoDTO.setImage("<https://www.example.com/image.png>");
        coingeckoDTO.setCurrent_price(50000.0);
        coingeckoDTO.setMarket_cap(900000000000L);
        coingeckoDTO.setMarket_cap_rank(1);
        coingeckoDTO.setFully_diluted_valuation(1000000000000L);

        coingeckoDTOList.add(coingeckoDTO);

        coingeckoFinalDTO.setCoingeckoDTO(coingeckoDTOList);

        Mockito.when(coingeckoService.getPrice(currency, ids)).thenReturn(coingeckoFinalDTO);

        mockMvc.perform(get("/crypto/coingecko/api/v1/coin")
                .param("currency", currency)
                .param("ids", ids.toArray(new String[0])))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(coingeckoFinalDTO)))
                .andDo(print());
        Mockito.verify(coingeckoService, Mockito.times(1)).getPrice(currency, ids);
        
    }
    @Test
    public void testGetPrices() throws Exception {
        // Setup mock response
        String currency = "usd";
        List<String> ids = new ArrayList<>();
        ids.add("bitcoin");
        ids.add("ethereum");
        
        CoingeckoFinalDTO mockResponse = new CoingeckoFinalDTO();
        mockResponse.setCode("000000");
        mockResponse.setMessage("OK");
        mockResponse.setCoingeckoDTO(null);

        // Define behavior of mocked service
        Mockito.when(coingeckoService.getPrice(currency, ids)).thenReturn(mockResponse);

        // Perform GET request and validate response
        mockMvc.perform(get("/crypto/coingecko/api/v1/coin")
                .param("currency", currency)
                .param("ids", ids.toArray(new String[0])))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(mockResponse)))
                .andDo(print());

        // Verify interaction with mocked service
        Mockito.verify(coingeckoService, Mockito.times(1)).getPrice(currency, ids);
    }


}


