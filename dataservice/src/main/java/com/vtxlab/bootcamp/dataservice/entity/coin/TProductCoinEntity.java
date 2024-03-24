package com.vtxlab.bootcamp.dataservice.entity.coin;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tproduct_coin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TProductCoinEntity implements Serializable{

  @Id
  private Long id;
  private Long coin_id;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;  
  
}
