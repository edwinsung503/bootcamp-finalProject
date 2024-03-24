package com.vtxlab.bootcamp.dataservice.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.dataservice.entity.stock.StockEntity;

@Repository
public interface StockRespoitory extends JpaRepository<StockEntity,Long>{
  
}
