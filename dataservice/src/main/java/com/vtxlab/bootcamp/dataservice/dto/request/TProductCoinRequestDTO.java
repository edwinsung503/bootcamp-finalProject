package com.vtxlab.bootcamp.dataservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TProductCoinRequestDTO {

  private Long id;
  private Long coin_id;
  private String name;
  private double curr_price;
  private double price_chg_pct;
  private double market_cap;
  private String logo;
  
}
