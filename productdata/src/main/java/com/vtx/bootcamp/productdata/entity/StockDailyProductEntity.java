package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tproduct_stocks_daily")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockDailyProductEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn(name = "stock_id", referencedColumnName = "id")
  private StockEntity stockEntities;
  private Timestamp trade_date;
  private double day_high;
  private double day_low;
  private double day_open;
  private double day_end;

  
}
