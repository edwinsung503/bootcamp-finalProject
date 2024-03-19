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
@Table(name = "texternal_stock_finnhub_quote")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinnhubQuoteEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Timestamp quote_date;
  private String quote_stock_code;
  private double curr_price;
  private double price_chg;
  private double price_chg_pct;
  private double price_day_high;
  private double price_day_low;
  private double price_prev_open;
  private double price_prev_close;

  
}
