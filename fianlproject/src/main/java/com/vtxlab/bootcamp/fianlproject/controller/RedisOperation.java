package com.vtxlab.bootcamp.fianlproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.fianlproject.model.CoinUser;

public interface RedisOperation {
    
    @PostMapping(value = "/coins1")
    CoinUser createUser (@RequestParam String key, @RequestParam CoinUser coinUser) 
        throws JsonProcessingException;
    
}
