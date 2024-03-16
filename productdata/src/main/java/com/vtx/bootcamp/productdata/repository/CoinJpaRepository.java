package com.vtx.bootcamp.productdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtx.bootcamp.productdata.entity.CoinEntity;


@Repository
public interface CoinJpaRepository extends JpaRepository<CoinEntity,Long>{
  
   
  void deleteByCoinId(String coin_id);
}
