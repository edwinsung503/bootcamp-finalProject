package com.vtxlab.bootcamp.finnhub.dto.response.Finnhub;

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
public class FinnhubStockDTO {
  
  private String c;
  private String d;
  private String dp;
  private String h;
  private String l;
  private String o;
  private String pc;
  private String t;
}
