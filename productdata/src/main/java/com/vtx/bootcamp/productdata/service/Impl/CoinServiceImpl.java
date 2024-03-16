package com.vtx.bootcamp.productdata.service.Impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtx.bootcamp.productdata.dto.mapper.CoinMapper;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import com.vtx.bootcamp.productdata.repository.CoinJpaRepository;
import com.vtx.bootcamp.productdata.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService{
  
  @Autowired
  private CoinJpaRepository coinJpaRepository;

  @Override
  public void addCoin(List<String> coinsId){
    for (String coin_id : coinsId){
      CoinEntity coinEntity = CoinMapper.map(coin_id);
      //coinJpaRepository.save(coinEntity);
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
}
