package com.vtxlab.bootcamp.finnhub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubCompanyProfileFinalDTO;
import com.vtxlab.bootcamp.finnhub.dto.response.Finnhub.FinnhubStockFinalDTO;


@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String, FinnhubStockFinalDTO> redisTemplate(RedisConnectionFactory factory) {
      RedisTemplate<String, FinnhubStockFinalDTO> redisTemplate = new RedisTemplate<>();
      redisTemplate.setConnectionFactory(factory);
      redisTemplate.setKeySerializer(new StringRedisSerializer());
      redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(FinnhubStockFinalDTO.class));// Using Jackson2JsonRedisSerializer to serialize CoingeckoFinalDTO objects
      return redisTemplate;
  }

  @Bean
  public RedisTemplate<String, FinnhubCompanyProfileFinalDTO> redisTemplateComp(RedisConnectionFactory factory) {
      RedisTemplate<String, FinnhubCompanyProfileFinalDTO> redisTemplateComp = new RedisTemplate<>();
      redisTemplateComp.setConnectionFactory(factory);
      redisTemplateComp.setKeySerializer(new StringRedisSerializer());
      redisTemplateComp.setValueSerializer(new Jackson2JsonRedisSerializer<>(FinnhubStockFinalDTO.class));// Using Jackson2JsonRedisSerializer to serialize CoingeckoFinalDTO objects
      return redisTemplateComp;
  }
}