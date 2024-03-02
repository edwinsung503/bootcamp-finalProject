package com.vtxlab.bootcamp.fianlproject.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.fianlproject.dto.response.CoingeckoFinalDTO;
import java.util.concurrent.TimeUnit;

@Component
public class RedisHelper {

    @Autowired
    private RedisTemplate<String, CoingeckoFinalDTO> redisTemplate;

    public CoingeckoFinalDTO getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void setValueWithExpiration(String key, CoingeckoFinalDTO value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }
}