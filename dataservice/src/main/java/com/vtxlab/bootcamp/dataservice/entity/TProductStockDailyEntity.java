package com.vtxlab.bootcamp.dataservice.entity;

import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class TProductStockDailyEntity {

  @Id
  private Long id;
  private Long stock_id;
  private Timestamp trade_date;
  private double day_high;
  private double day_low;
  private double day_open;
  private double day_end;
  
}
