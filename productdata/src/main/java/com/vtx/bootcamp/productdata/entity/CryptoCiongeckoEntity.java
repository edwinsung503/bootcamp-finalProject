package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import java.sql.Timestamp;
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
@Table (name = "texternal_crypto_coingecko_market")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptoCiongeckoEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Timestamp quote_date;
  private String qutoe_coin_code;
  private String qutoe_currency;
  private String name;
  private String image;
  private double curr_price;
  private double market_cap;
  private double full_diluted_valuation;
  private double total_voulume;
  private double high_24;
  private double low_24h;
  private double price_change_24h; 
  private double price_change_pct_24h;
  private double market_cap_change_24h;
  private double market_cap_change_pct_24h;
  private double circulating_supply;
  private double total_supply;
  private double max_supply;
  private double ath;
  private double ath_change_percentage;
  private Timestamp ath_date;
  private double atl;
  private double atl_change_percentage;
  private Timestamp atl_date;


  
}
