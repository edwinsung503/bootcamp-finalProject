package com.vtxlab.bootcamp.coingecko;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.coingecko.controller.impl.CoingeckoController;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;
import com.vtxlab.bootcamp.coingecko.dto.response.Roi;
import com.vtxlab.bootcamp.coingecko.service.CoingeckoService;
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
        CoingeckoFinalDTO coingeckoFinalDTO = new CoingeckoFinalDTO();
        coingeckoFinalDTO.setCode("000000");
        coingeckoFinalDTO.setMessage("OK");
        List<CoingeckoDTO> coingeckoDTOList = new ArrayList<>();
        CoingeckoDTO coingeckoDTO = new CoingeckoDTO();
        coingeckoDTO.setId("bitcoin");
        coingeckoDTO.setSymbol("btc");
        coingeckoDTO.setName("Bitcoin");
        coingeckoDTO.setImage("https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400");
        coingeckoDTO.setCurrent_price(51482);
        coingeckoDTO.setMarket_cap(1010974066428L);
        coingeckoDTO.setMarket_cap_rank(1);
        coingeckoDTO.setFully_diluted_valuation(1081091223606L);
        coingeckoDTO.setTotal_volume(14639855950L);
        coingeckoDTO.setHigh_24h(51918);
        coingeckoDTO.setLow_24h(51308);
        coingeckoDTO.setPrice_change_24h(-119.34466764634999);
        coingeckoDTO.setPrice_change_percentage_24h(-0.23128);
        coingeckoDTO.setMarket_cap_change_24h(-1871228519.033081);
        coingeckoDTO.setMarket_cap_change_percentage_24h(-0.18475);
        coingeckoDTO.setCirculating_supply(19637987.0);
        coingeckoDTO.setTotal_supply(21000000.0);
        coingeckoDTO.setMax_supply(21000000.0);
        coingeckoDTO.setAth(69045);
        coingeckoDTO.setAth_change_percentage(-25.43923);
        coingeckoDTO.setAth_date("2021-11-10T14:24:11.849Z");
        coingeckoDTO.setAtl(67.81);
        coingeckoDTO.setAtl_change_percentage(75819.58589);
        coingeckoDTO.setAtl_date("2013-07-06T00:00:00.000Z");
        Roi roi = new Roi();
        roi.setTimes(79.53326355076948);
        roi.setCurrency("btc");
        roi.setPercentage(7953.326355076947);
        coingeckoDTO.setRoi(roi);
        coingeckoDTO.setLast_updated("2024-02-26T03:41:28.871Z");


        coingeckoDTOList.add(coingeckoDTO);

        coingeckoFinalDTO.setCoingeckoDTO(coingeckoDTOList);

        Mockito.when(coingeckoService.getPrice(currency, ids)).thenReturn(coingeckoFinalDTO);

        mockMvc.perform(get("/crypto/coingecko/api/v1/coins")
                .param("currency", currency)
                .param("ids", ids.toArray(new String[0])))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) 
                .andExpect(jsonPath("$.code").value("000000"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data[0].id").value("bitcoin"))
                .andExpect(jsonPath("$.data[0].symbol").value("btc"))
                .andExpect(jsonPath("$.data[0].name").value("Bitcoin"))
                .andExpect(jsonPath("$.data[0].image").value("https://assets.coingecko.com/coins/images/1/large/bitcoin.png?1696501400"))
                .andExpect(jsonPath("$.data[0].currentPrice").value(51482))
                .andExpect(jsonPath("$.data[0].marketCap").value(1010974066428L))
                .andExpect(jsonPath("$.data[0].marketCapRank").value(1))
                .andExpect(jsonPath("$.data[0].fullyDilutedValuation").value(1081091223606L))
                .andExpect(jsonPath("$.data[0].totalVolume").value(14639855950L))
                .andExpect(jsonPath("$.data[0].high24h").value(51918))
                .andExpect(jsonPath("$.data[0].low24h").value(51308))
                .andExpect(jsonPath("$.data[0].priceChange24h").value(-119.34466764634999))
                .andExpect(jsonPath("$.data[0].priceChangePercentage24h").value(-0.23128))
                .andExpect(jsonPath("$.data[0].marketCapChange24h").value(-1871228519.033081))
                .andExpect(jsonPath("$.data[0].marketCapChangePercentage24h").value(-0.18475))
                .andExpect(jsonPath("$.data[0].circulatingSupply").value(19637987.0))
                .andExpect(jsonPath("$.data[0].totalSupply").value(21000000.0))
                .andExpect(jsonPath("$.data[0].maxSupply").value(21000000.0))
                .andExpect(jsonPath("$.data[0].ath").value(69045))
                .andExpect(jsonPath("$.data[0].athChangePercentage").value(-25.43923))
                .andExpect(jsonPath("$.data[0].athDate").value("2021-11-10T14:24:11.849Z"))
                .andExpect(jsonPath("$.data[0].atl").value(67.81))
                .andExpect(jsonPath("$.data[0].atlChangePercentage").value(75819.585890))
                .andExpect(jsonPath("$.data[0].atlDate").value("2013-07-06T00:00:00.000Z"))
                .andExpect(jsonPath("$.data[0].roi.times").value(79.53326355076948))
                .andExpect(jsonPath("$.data[0].roi.currency").value("btc"))
                .andExpect(jsonPath("$.data[0].roi.percentage").value(7953.326355076947))
                .andExpect(jsonPath("$.data[0].lastUpdated").value("2024-02-26T03:41:28.871Z"))
                .andDo(print());
        
    }
}


