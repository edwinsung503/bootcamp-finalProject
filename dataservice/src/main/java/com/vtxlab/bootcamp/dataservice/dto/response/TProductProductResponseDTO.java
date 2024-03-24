package com.vtxlab.bootcamp.dataservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TProductProductResponseDTO {

  private String productId;
  private String name;
  private double curr_price;
  @JsonProperty(value="currentPrice")
    public double getCurrent_Price(){
        return this.curr_price;
    }
  private double price_chg_pct;
  @JsonProperty(value ="priceChangePct")
    public double getPrice_Change_Pct(){
      return this.price_chg_pct;
    }
  private double market_cap;
  @JsonProperty(value = "marketCap")
    public double getMarket_Cap(){
      return this.market_cap;
    }
  private String logo;

  
}
