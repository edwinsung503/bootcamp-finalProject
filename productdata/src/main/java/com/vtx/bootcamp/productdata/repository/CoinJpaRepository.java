package com.vtx.bootcamp.productdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtx.bootcamp.productdata.entity.CoinEntity;
import java.util.List;

@Repository
public interface CoinJpaRepository extends JpaRepository<CoinEntity,Long>{
  
  List<CoinEntity> findByCoinId(String coinId);

  void deleteByCoinId(String coin_id);
}
