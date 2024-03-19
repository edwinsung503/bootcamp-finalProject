package com.vtx.bootcamp.productdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtx.bootcamp.productdata.entity.FinnhubProfileEntity;

@Repository
public interface FinnhubProfileRespository extends JpaRepository<FinnhubProfileEntity, Long>{
  
}
