package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class CoinProductEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long coin_id;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;
  
}
