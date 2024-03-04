package com.vtxlab.bootcamp.coingecko.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roi {

  private double times;
  private String currency;
  private double percentage;
  
}
