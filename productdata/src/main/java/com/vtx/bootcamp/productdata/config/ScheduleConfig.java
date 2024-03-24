package com.vtx.bootcamp.productdata.config;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.entity.CryptoCiongeckoEntity;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.repository.CryptoCiongeckoRepository;
import com.vtx.bootcamp.productdata.repository.FinnhubProfileRespository;
import com.vtx.bootcamp.productdata.repository.FinnhubQuoteRepository;
import com.vtx.bootcamp.productdata.repository.StockJpaRepository;
import com.vtx.bootcamp.productdata.service.Impl.CoinServiceImpl;
import com.vtx.bootcamp.productdata.service.Impl.StockServiceImpl;

@Configuration
@EnableScheduling
public class ScheduleConfig {

  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Autowired
  private StockJpaRepository stockJpaRepository;

  @Autowired
  private CoinServiceImpl coinServiceImpl;

  @Autowired
  private StockServiceImpl stockServiceImpl;

  @Autowired
  private CryptoCiongeckoRepository ciongeckoRepository;

  @Autowired
  private FinnhubQuoteRepository finnhubQuoteRepository;

  @Autowired
  private FinnhubProfileRespository finnhubProfileRespository;

  @Scheduled(fixedDelay = 60000) // 600000 -> 10mins
  public void fixedDelayTaskCoins() throws InterruptedException{
    System.out.println("start fixedDelayTask: Coins Price");
    List<CoinEntity> coin = coinJpaRepository.findAll();
    List<String> coinList = new ArrayList<>();
    if (!coin.isEmpty()){
      for (CoinEntity c : coin){
        coinList.add(c.getCoinId()) ;
      }
    }
    System.out.println(coinList.toString());
    LocalTime currentTime = LocalTime.now();
    coinServiceImpl.deleteCoinPrice(currentTime);
    coinServiceImpl.getCoinPrice(coinList);
    System.out.println("end fixedDelayTask: Coins Price");
  }
  
  @Scheduled(fixedDelay = 60000)
  public void fixedDelayTaskStocksQuote() throws InterruptedException{
    System.out.println("start fixedDelayTask: Stocks Price");
    List<StockEntity> stock = stockJpaRepository.findAll();
    List<String> stockList = new ArrayList<>();
    if (!stock.isEmpty()){
      for (StockEntity s : stock){
        stockList.add(s.getStockId());
      }
    }
    System.out.println(stockList.toString());
    LocalTime currentTime = LocalTime.now();
    stockServiceImpl.deleteStockPrice(currentTime);
    stockServiceImpl.getStockPrice(stockList);
    System.out.println("end fixedDelayTask: Stocks Price");
  }

  @Scheduled(fixedDelay = 60000)
  public void fixedDelayTaskStocksProfile() throws InterruptedException{
    System.out.println("start fixedDelayTask: Stocks Profile");
    List<StockEntity> stock = stockJpaRepository.findAll();
    List<String> stockList = new ArrayList<>();
    if (! stock.isEmpty()){
      for  (StockEntity s : stock){
        stockList.add(s.getStockId());
      }
    }
    System.out.println(stockList.toString());
    LocalTime currentTime = LocalTime.now();
    stockServiceImpl.deleteStockProfile(currentTime);
    stockServiceImpl.getStockProfile(stockList);
    System.out.println("end fixedDelayTask: Stocks Profile");
  }

  @Scheduled(fixedDelay = 60000)
  public void fixedDelayTaskCoinRetrive() throws InterruptedException{
    System.out.println("start fixedDelayTask: Coin Retrive");
    List<CryptoCiongeckoEntity> cryptoCiongeckoEntities = ciongeckoRepository.findAll();
    List<CoinEntity> coin = coinJpaRepository.findAll();
    int total = cryptoCiongeckoEntities.size();
    for (CoinEntity c : coin){
      for (int i = total - 1  ; i > 0 ; i--){
        if (cryptoCiongeckoEntities.get(i).getQutoe_currency().equals(c.getCoinId())){
          coinServiceImpl.saveCoin(cryptoCiongeckoEntities.get(i),c);
          break;
        }
      }
    }  
    System.out.println("end fixedDelayTask: Coin Retrive");
  }
  @Scheduled(fixedDelay = 60000)
  public void fixedDelayTaskStockRetrive() throws InterruptedException{
    System.out.println("start fixedDelayTask: Stock Retrive");
    List<FinnhubQuoteEntity> finnhubQuoteEntities = finnhubQuoteRepository.findAll();
    List<FinnhubProfileEntity> finnhubProfileEntities = finnhubProfileRespository.findAll();
    List<StockEntity> stock = stockJpaRepository.findAll();
    int total = finnhubQuoteEntities.size();
    for (StockEntity s : stock){
      for (int i = total -1 ; i> 0 ;i--){
        if (finnhubQuoteEntities.get(i).getQuote_stock_code().equals(s.getStockId())){
          stockServiceImpl.saveStock(finnhubProfileEntities.get(i-1), finnhubQuoteEntities.get(i), s);
          break;
        }
      }
    }
    System.out.println("end fixedDelayTask: Stock Retrive");
  }
  @Scheduled(cron = "0 0 6 * * MON-SAT")
  public void fixedDelayTaskStockDailyRetrive() throws InterruptedException{
    System.out.println("start fixedDelayTask: Stock Daily Retrive");
    List<FinnhubQuoteEntity> finnhubQuoteEntities = finnhubQuoteRepository.findAll();
    List<StockEntity> stock = stockJpaRepository.findAll();
    int total = finnhubQuoteEntities.size();
    for (StockEntity s : stock){
      for (int i = total -1 ; i> 0 ;i--){
        if (finnhubQuoteEntities.get(i).getQuote_stock_code().equals(s.getStockId())){
          stockServiceImpl.saveDailyStock(finnhubQuoteEntities.get(i), s);
          break;
        }
      }
    }
    System.out.println("end fixedDelayTask: Stock Daily Retrive");
  }


}
