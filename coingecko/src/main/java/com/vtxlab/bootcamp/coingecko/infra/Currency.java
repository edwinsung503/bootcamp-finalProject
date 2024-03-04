package com.vtxlab.bootcamp.coingecko.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
  
  USD("usd");

  private String name;
}
