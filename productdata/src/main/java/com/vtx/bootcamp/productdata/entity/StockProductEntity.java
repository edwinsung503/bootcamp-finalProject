package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tproduct_stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockProductEntity implements Serializable{
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name = "stock_id", referencedColumnName = "id")
  private StockEntity stockEntity;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;
}
