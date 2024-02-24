package com.vtxlab.bootcamp.fianlproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.fianlproject.infra.RedisHelper;
import com.vtxlab.bootcamp.fianlproject.model.CoinUser;
import com.vtxlab.bootcamp.fianlproject.service.RedisService;

public class RedisServiceImpl implements RedisService{
  
  @Autowired
  private RedisHelper redisHelper;

  @Override
  public CoinUser createUser(String key, CoinUser coinUser) throws JsonProcessingException {
    redisHelper.set(key , coinUser);
    return coinUser;
  }
}
