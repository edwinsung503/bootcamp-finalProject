package com.vtx.bootcamp.productdata.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtx.bootcamp.productdata.dto.mapper.StockMapper;
import com.vtx.bootcamp.productdata.dto.response.StockDTO;
import com.vtx.bootcamp.productdata.entity.StockEntity;
import com.vtx.bootcamp.productdata.repository.StockJpaRepository;
import com.vtx.bootcamp.productdata.service.StockService;

@Service
public class StockServiceImpl implements StockService{

  @Autowired
  private StockJpaRepository stockJpaRepository;

  @Override
  public void addStock( List<StockDTO> stocksId){
    //dto -> Entity 過程
    for (StockDTO stockDTO: stocksId){
      StockEntity stockEntity = StockMapper.map(stockDTO);
      stockJpaRepository.save(stockEntity);
      //if (stockJpaRepository.findByStockId(stockEntity) )
       // stockJpaRepository.save(stockEntity);
    }       
  }

  @Override
  public void deleteStock(List<String> stockId){
    for (String stockIds : stockId){
      stockJpaRepository.deleteByStockId(stockIds);
    }
    
  }
}
