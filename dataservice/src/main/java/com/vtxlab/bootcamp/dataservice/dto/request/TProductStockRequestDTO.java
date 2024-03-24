package com.vtxlab.bootcamp.dataservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TProductStockRequestDTO {

  private Long id;
  private Long stock_id;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;

  
}
