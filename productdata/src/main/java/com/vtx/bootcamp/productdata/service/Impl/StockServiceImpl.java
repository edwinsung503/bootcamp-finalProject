package com.vtx.bootcamp.productdata.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtx.bootcamp.productdata.dto.mapper.StockMapper;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.repository.StockJpaRepository;
import com.vtx.bootcamp.productdata.service.StockService;

@Service
public class StockServiceImpl implements StockService{

  @Autowired
  private StockJpaRepository stockJpaRepository;

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
          if ( stockEntity.getStockId().equals(stockidEntity.getStockId())){
            System.out.println("Equal");
          } else {
            stockJpaRepository.save(stockEntity);
            System.out.println("Saved");
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
}
