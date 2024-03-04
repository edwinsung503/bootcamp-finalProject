package com.vtxlab.bootcamp.finnhub.infra;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;

@Component
public class RedisHelper {

  @Autowired
  private RedisTemplate<String, FinnhubStockFinalDTO> redisTemplate;

  public FinnhubStockFinalDTO getValue(String key){
    return redisTemplate.opsForValue().get(key);
  }

  public void setValueWithExpiration(String key, FinnhubStockFinalDTO value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }


  
}
