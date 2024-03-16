package com.vtx.bootcamp.productdata.service.Impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtx.bootcamp.productdata.dto.mapper.CoinMapper;
import com.vtx.bootcamp.productdata.dto.response.CoinDTO;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{
  
  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Override
  public void addCoin(List<CoinDTO> coinsId){
    for (CoinDTO coinDTO : coinsId){
      CoinEntity coinEntity = CoinMapper.map(coinDTO);
      coinJpaRepository.save(coinEntity);
    }
    
  }
}
