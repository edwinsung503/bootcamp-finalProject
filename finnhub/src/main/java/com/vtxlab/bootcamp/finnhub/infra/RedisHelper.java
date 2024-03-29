package com.vtxlab.bootcamp.finnhub.infra;

import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;

@Component
public class RedisHelper {

  @Autowired
  private RedisTemplate<String, FinnhubStockFinalDTO> redisTemplate;

  @Autowired
  private RedisTemplate<String , FinnhubCompanyProfileFinalDTO> redisTemplateComp;

  public FinnhubStockFinalDTO getValue(String key){
    return redisTemplate.opsForValue().get(key);
  }

  public void setValueWithExpiration(String key, FinnhubStockFinalDTO value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
  }

  public FinnhubCompanyProfileFinalDTO getValue2(String key){
    return redisTemplateComp.opsForValue().get(key);
  }

  public void setValueWithExpiration2(String key, FinnhubCompanyProfileFinalDTO value, long timeout, TimeUnit timeUnit) {
        redisTemplateComp.opsForValue().set(key, value, timeout, timeUnit);
  }

  
}
