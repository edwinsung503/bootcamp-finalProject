package com.vtxlab.bootcamp.dataservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.dataservice.entity.TProductStockDailyEntity;

@Repository
public interface TProductStockDailyRespoitory extends JpaRepository<TProductStockDailyEntity,Long> {
  
}
