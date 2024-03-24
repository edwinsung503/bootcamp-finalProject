package com.vtx.bootcamp.productdata.service.Impl;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtx.bootcamp.productdata.dto.mapper.FinnhubProfileMapper;
import com.vtx.bootcamp.productdata.dto.mapper.FinnhubQuoteMapper;
import com.vtx.bootcamp.productdata.dto.mapper.StockDailyProductMapper;
import com.vtx.bootcamp.productdata.dto.mapper.StockMapper;
import com.vtx.bootcamp.productdata.dto.mapper.StockProductMapper;
import com.vtx.bootcamp.productdata.dto.request.FinnhubProfileDTO;
import com.vtx.bootcamp.productdata.dto.request.FinnhubQuoteDTO;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;
import com.vtx.bootcamp.productdata.entity.StockDailyProductEntity;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.entity.StockProductEntity;
import com.vtx.bootcamp.productdata.repository.FinnhubProfileRespository;
import com.vtx.bootcamp.productdata.repository.FinnhubQuoteRepository;
import com.vtx.bootcamp.productdata.repository.StockDailyProductRepository;
import com.vtx.bootcamp.productdata.repository.StockJpaRepository;
import com.vtx.bootcamp.productdata.repository.StockProductRepository;
import com.vtx.bootcamp.productdata.service.StockService;

@Service
public class StockServiceImpl implements StockService{

  @Value(value = "${url.stockQuote}")
  private String stockQuote;

  @Value(value = "${url.stockProfile}")
  private String stockProfile;

  @Value("${housekeeping.time}")
  private int time;

  @Autowired
  private StockJpaRepository stockJpaRepository;

  @Autowired
  private FinnhubQuoteRepository finnhubQuoteRepository;

  @Autowired
  private FinnhubProfileRespository finnhubProfileRespository;

  @Autowired
  private StockProductRepository stockProductRepository;

  @Autowired
  private StockDailyProductRepository stockDailyProductRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public void addStock( List<String> stocksId){
    //dto -> Entity 過程
    for (String stock_id: stocksId){
      StockEntity stockEntity = StockMapper.map(stock_id);

      List<StockEntity> stockidsEntities = stockJpaRepository.findByStockId(stock_id);
      if (stockidsEntities.isEmpty()){
        stockJpaRepository.save(stockEntity);
      } else {
        for (StockEntity stockidEntity : stockidsEntities){
          if (! stockEntity.getStockId().equals(stockidEntity.getStockId())){
            stockJpaRepository.save(stockEntity);
          } 
        }
      }    
    }
  }

  @Override
  public void deleteStock(List<String> stockId){
    for (String stockIds : stockId){
      stockJpaRepository.deleteByStockId(stockIds);
    }
    
  }
  @Override
  public void getStockPrice(List<String> stockList){
    for (String stocks : stockList){
      String url = stockQuote + stocks;
      FinnhubQuoteDTO finnhubQuoteDTOs = restTemplate.getForObject(url, FinnhubQuoteDTO.class);
      FinnhubQuoteEntity finnhubQuoteEntity = FinnhubQuoteMapper.map(finnhubQuoteDTOs,stocks);
      finnhubQuoteRepository.save(finnhubQuoteEntity);

    }
  }

  @Override
  public void deleteStockPrice(LocalTime currentTime){
    List<FinnhubQuoteEntity> finnhubQuoteEntity = finnhubQuoteRepository.findAll();
    for (FinnhubQuoteEntity finnhubQuoteEntities : finnhubQuoteEntity){
      LocalTime timeFromTimestamp = finnhubQuoteEntities.getQuote_date().toLocalDateTime().toLocalTime();
      Duration duration = Duration.between(timeFromTimestamp, currentTime);
      if (duration.compareTo(Duration.ofHours(time)) > 0 ){
        finnhubQuoteRepository.deleteById(finnhubQuoteEntities.getId());
      }
    }
  }

  @Override
  public void getStockProfile(List<String> stockList){
    for (String stocks : stockList){
      String url = stockProfile + stocks;
      FinnhubProfileDTO finnhubProfileDTOs = restTemplate.getForObject(url, FinnhubProfileDTO.class);
      FinnhubProfileEntity finnhubProfileEntity = FinnhubProfileMapper.map(finnhubProfileDTOs,stocks);
      finnhubProfileRespository.save(finnhubProfileEntity);
    }
  }
  
  @Override
  public void deleteStockProfile(LocalTime currentTime){
    List<FinnhubProfileEntity> finnhubProfileEntity = finnhubProfileRespository.findAll();
    for (FinnhubProfileEntity finnhubProfileEntities : finnhubProfileEntity){
      LocalTime timeFromTimestamp = finnhubProfileEntities.getQuote_date().toLocalDateTime().toLocalTime();
      Duration duration = Duration.between(timeFromTimestamp, currentTime);
      if (duration.compareTo(Duration.ofHours(time)) > 0) {
        finnhubProfileRespository.deleteById(finnhubProfileEntities.getId());
      }
    }
  }

  @Override
  public void saveStock(FinnhubProfileEntity finnhubProfileEntity, FinnhubQuoteEntity finnhubQuoteEntity,StockEntity stockEntity){
    List<StockProductEntity> stockProductEntities = stockProductRepository.findAll();
    StockProductEntity stockProductEntity = StockProductMapper.map(finnhubProfileEntity,finnhubQuoteEntity,stockEntity);
    if (stockProductEntities.isEmpty()){
      stockProductRepository.save(stockProductEntity);
    } else {
      stockProductRepository.deleteAll();
      for (StockProductEntity s : stockProductEntities){
        stockProductRepository.save(stockProductEntity);
      }
    }
  }

  @Override
  public void saveDailyStock(FinnhubQuoteEntity finnhubQuoteEntity,StockEntity stockEntity){
    List<StockDailyProductEntity> stockDailyProductEntities = stockDailyProductRepository.findAll();
    StockDailyProductEntity stockDailyProductEntity = StockDailyProductMapper.map(finnhubQuoteEntity, stockEntity);
    if (stockDailyProductEntities.isEmpty()){
      stockDailyProductRepository.save(stockDailyProductEntity);
    }
    for (StockDailyProductEntity s : stockDailyProductEntities){
      stockDailyProductRepository.save(stockDailyProductEntity);
    }
  }
}
