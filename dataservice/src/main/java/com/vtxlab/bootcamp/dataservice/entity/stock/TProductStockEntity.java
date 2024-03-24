package com.vtxlab.bootcamp.dataservice.entity.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class TProductStockEntity {
  
  @Id
  private Long id;
  private Long stock_id;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;  
  
}
