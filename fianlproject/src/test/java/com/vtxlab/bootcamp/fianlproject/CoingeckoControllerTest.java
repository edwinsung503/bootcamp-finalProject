package com.vtxlab.bootcamp.fianlproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.fianlproject.controller.impl.CoingeckoController;
import com.vtxlab.bootcamp.fianlproject.dto.request.Coingeckos;
import com.vtxlab.bootcamp.fianlproject.service.CoingeckoService;

@WebMvcTest(CoingeckoController.class)
public class CoingeckoControllerTest {

    @MockBean
    private CoingeckoService coingeckoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPriceMethod() throws Exception{
        
        Coingeckos coingecko = new Coingeckos();
        
    }
    
}
