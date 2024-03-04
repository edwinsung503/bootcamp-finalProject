package com.vtxlab.bootcamp.finnhub.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FinnhubStockQuotes {

  private String c;
  private String d;
  private String dp;
  private String h;
  private String l;
  private String o;
  private String pc;
  private String t;

}
