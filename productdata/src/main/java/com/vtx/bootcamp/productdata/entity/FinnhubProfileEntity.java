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
@Table(name = "texternal_stock_finnhub_profile2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinnhubProfileEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Timestamp quote_date;
  private String quote_stock_code;
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  private double marketCapitalization;
  private String name;
  private String phone;
  private double shareOutstanding;
  private String ticker;
  private String weburl;

  
}
