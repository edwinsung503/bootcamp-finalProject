package com.vtxlab.bootcamp.dataservice.infra;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;

@Component
public class RedisHelper {

  @Autowired
  private RedisTemplate<String,RedisProductFinalResponseDTO> redisTemplate;

  public RedisProductFinalResponseDTO getValue(String key){
    return redisTemplate.opsForValue().get(key);
  }

  public void setValueWithExpiration(String key, RedisProductFinalResponseDTO value, long timeout, TimeUnit timeUnit){
    redisTemplate.opsForValue().set(key, value,timeout,timeUnit);
  }
  
}
