package com.vtxlab.bootcamp.fianlproject.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.fianlproject.controller.RedisOperation;
import com.vtxlab.bootcamp.fianlproject.model.CoinUser;
import com.vtxlab.bootcamp.fianlproject.service.RedisService;

@RestController
@RequestMapping(value = "/redis/api/v1")
public class RedisController implements RedisOperation {

  @Autowired
  private RedisService redisService;

  @Override
  public CoinUser createUser(String key, CoinUser coinUser)throws JsonProcessingException{
    return redisService.createUser(key, coinUser);
  }
    
}
