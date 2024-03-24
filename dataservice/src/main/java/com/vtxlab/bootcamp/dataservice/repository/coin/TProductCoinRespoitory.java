package com.vtxlab.bootcamp.dataservice.repository.coin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.dataservice.entity.coin.TProductCoinEntity;

@Repository
public interface TProductCoinRespoitory extends JpaRepository<TProductCoinEntity,Long>{

}
