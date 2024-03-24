package com.vtxlab.bootcamp.dataservice.repository.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.dataservice.entity.stock.TProductStockEntity;

@Repository
public interface TProductStockRespoitory extends JpaRepository<TProductStockEntity,Long>{
  
}
