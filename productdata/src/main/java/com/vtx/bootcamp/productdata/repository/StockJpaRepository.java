package com.vtx.bootcamp.productdata.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtx.bootcamp.productdata.entity.StockEntity;



@Repository
public interface StockJpaRepository extends JpaRepository<StockEntity,Long>{

  List<StockEntity> findByStockId(String stockId);

  void deleteByStockId(String stock_id);
}
