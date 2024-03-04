package com.vtxlab.bootcamp.coingecko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.vtxlab.bootcamp.coingecko.dto.response.CoingeckoFinalDTO;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, CoingeckoFinalDTO> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, CoingeckoFinalDTO> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(CoingeckoFinalDTO.class));// Using Jackson2JsonRedisSerializer to serialize CoingeckoFinalDTO objects
        return redisTemplate;
    }
}
