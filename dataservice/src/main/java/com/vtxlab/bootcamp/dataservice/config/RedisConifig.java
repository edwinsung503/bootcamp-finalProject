package com.vtxlab.bootcamp.dataservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;

@Configuration
public class RedisConifig {

  @Bean
  public RedisTemplate<String,RedisProductFinalResponseDTO> redisTemplate(RedisConnectionFactory factory){
    RedisTemplate<String , RedisProductFinalResponseDTO> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisProductFinalResponseDTO.class));
    return redisTemplate;
  }
  
}
