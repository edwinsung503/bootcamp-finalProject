package com.vtx.bootcamp.productdata.service.Impl;


import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtx.bootcamp.productdata.dto.mapper.CoinMapper;
import com.vtx.bootcamp.productdata.dto.mapper.CoinProductMapper;
import com.vtx.bootcamp.productdata.dto.mapper.CryptoCiongeckoMapper;
import com.vtx.bootcamp.productdata.dto.request.CryptoCoingeckoDTO;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.entity.CoinProductEntity;
import com.vtx.bootcamp.productdata.entity.CryptoCiongeckoEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.repository.CoinProductRepository;
import com.vtx.bootcamp.productdata.repository.CryptoCiongeckoRepository;
import com.vtx.bootcamp.productdata.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{
  
  @Value("${currency.type}")
  private String usd;

  @Value("${url.domain}")
  private String domain;

  @Value("${housekeeping.time}")
  private int time;

  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Autowired
  private CryptoCiongeckoRepository cryptoCiongeckoRepository;

  @Autowired
  private CoinProductRepository coinProductRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public void addCoin(List<String> coinsId){
    for (String coin_id : coinsId){
      CoinEntity coinEntity = CoinMapper.map(coin_id);
      List<CoinEntity> coinEntities = coinJpaRepository.findByCoinId(coin_id);
      if (coinEntities.isEmpty()){
        coinJpaRepository.save(coinEntity);
      } else {
        for (CoinEntity coinidEntity : coinEntities){
          if (coinEntity.getCoinId().equals(coinidEntity.getCoinId())){
            System.out.println("Equal");
          }
          else {
            coinJpaRepository.save(coinEntity);
            System.out.println("Saved");
          }
        }
      }
    }
  }

  @Override
  public void deleteCoin(List<String> coinId){
    for (String coinIds : coinId){
      coinJpaRepository.deleteByCoinId(coinIds);
    }
  }

  @Override
  public void getCoinPrice(List<String> coinList){   
    for (String coins : coinList){
      String url = domain+"?currency="+usd+"&ids="+coins;
      CryptoCoingeckoDTO cryptoCoingeckoDTOs = restTemplate.getForObject(url, CryptoCoingeckoDTO.class);
      CryptoCiongeckoEntity cryptoCiongeckoEntity = CryptoCiongeckoMapper.map(cryptoCoingeckoDTOs,coins);
      cryptoCiongeckoRepository.save(cryptoCiongeckoEntity);
    }
    
  }

  @Override
  public void deleteCoinPrice(LocalTime currentTime){
    List<CryptoCiongeckoEntity> cryptoCiongeckoEntity = cryptoCiongeckoRepository.findAll();
    for(CryptoCiongeckoEntity cryptoCiongeckoEntities : cryptoCiongeckoEntity){
      LocalTime timeFromTimestamp = cryptoCiongeckoEntities.getQuote_date().toLocalDateTime().toLocalTime();
      Duration duration = Duration.between(timeFromTimestamp, currentTime);
      if (duration.compareTo(Duration.ofHours(time)) > 0) {
        cryptoCiongeckoRepository.deleteById(cryptoCiongeckoEntities.getId());
      } 
    }
  }

  @Override
  public void saveCoin(CryptoCiongeckoEntity cryptoCiongeckoEntity){
    CoinProductEntity coinProductEntity = CoinProductMapper.map(cryptoCiongeckoEntity);
    coinProductRepository.save(coinProductEntity);
  }
}
