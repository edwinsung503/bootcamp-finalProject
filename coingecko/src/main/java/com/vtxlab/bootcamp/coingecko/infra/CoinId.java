package com.vtxlab.bootcamp.coingecko.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CoinId {

    BITCOIN("bitcoin"),
    ETHEREUM("ethereum");

    private String name;
    
}
