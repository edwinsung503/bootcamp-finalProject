package com.vtxlab.bootcamp.dataservice.service.Impl;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductFinalResponseDTO;
import com.vtxlab.bootcamp.dataservice.dto.response.RedisProductResponseDTO;
import com.vtxlab.bootcamp.dataservice.entity.TProductStockDailyEntity;
import com.vtxlab.bootcamp.dataservice.entity.stock.StockEntity;
import com.vtxlab.bootcamp.dataservice.infra.RedisHelper;
import com.vtxlab.bootcamp.dataservice.infra.Syscode;
import com.vtxlab.bootcamp.dataservice.repository.TProductStockDailyRespoitory;
import com.vtxlab.bootcamp.dataservice.repository.stock.StockRespoitory;
import com.vtxlab.bootcamp.dataservice.service.RedisStockDailyService;

@Service
public class RedisStockDailyServiceImpl  implements RedisStockDailyService{

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private RedisHelper redisHelper;
  
  @Autowired
  private TProductStockDailyRespoitory tProductStockDailyRespoitory;

  @Autowired
  private StockRespoitory stockRespoitory;
  
  @Override
  public RedisProductFinalResponseDTO getStockDailyData(List<String> stocksId){

    String key = "stock:daily:" + stocksId;
    RedisProductFinalResponseDTO stockData = redisHelper.getValue(key);

    if (stockData != null){
      return stockData;
    } else {
      try {
        List<TProductStockDailyEntity> tProductStockDailyEntities = tProductStockDailyRespoitory.findAll();
        List<StockEntity> stockEntities = stockRespoitory.findAll();

        
        List<RedisProductResponseDTO> redisProductResponseDTOs = tProductStockDailyEntities.stream()
              .map(p -> {
                StockEntity stockEntity = stockEntities.stream()
                .filter(stock -> stock.getId().equals(p.getStock_id()))
                .findFirst()
                .orElse(null);

                String stockCode = (stockEntity != null) ? stockEntity.getStock_code() : null;

                return RedisProductResponseDTO.builder()
                    .productId(stockCode)
                    .trade_date(p.getTrade_date())
                    .day_high(p.getDay_high())
                    .day_low(p.getDay_low())
                    .day_open(p.getDay_open())
                    .day_end(p.getDay_end())
                    .build();

              }).collect(Collectors.toList());

          RedisProductFinalResponseDTO response = RedisProductFinalResponseDTO.builder()
            .code(Syscode.OK.getCode())
            .message(Syscode.OK.getMessage())
            .redisProductResponseDTO(redisProductResponseDTOs)
            .build();

          redisHelper.setValueWithExpiration(key, response, 24, TimeUnit.HOURS);
          return response;
      } catch (Exception e) {
        return RedisProductFinalResponseDTO.builder()
            .code(Syscode.REST_CLIENT_EXCEPTION.getCode())
            .message(Syscode.REST_CLIENT_EXCEPTION.getMessage())
            .redisProductResponseDTO(null)
            .build();
      }
      
    }
    
  }
  
}
