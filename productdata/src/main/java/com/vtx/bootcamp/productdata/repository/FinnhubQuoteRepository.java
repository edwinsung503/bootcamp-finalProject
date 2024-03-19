package com.vtx.bootcamp.productdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtx.bootcamp.productdata.entity.FinnhubQuoteEntity;

@Repository
public interface FinnhubQuoteRepository extends JpaRepository<FinnhubQuoteEntity,Long>{
  
}
