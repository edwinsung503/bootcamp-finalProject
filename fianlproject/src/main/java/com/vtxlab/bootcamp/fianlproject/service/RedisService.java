package com.vtxlab.bootcamp.fianlproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.fianlproject.model.CoinUser;

public interface RedisService {
    
  CoinUser createUser(String key, CoinUser coinUser) throws JsonProcessingException;
}
