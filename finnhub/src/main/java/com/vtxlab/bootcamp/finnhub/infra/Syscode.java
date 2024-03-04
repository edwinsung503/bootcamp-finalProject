package com.vtxlab.bootcamp.finnhub.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Syscode {

    OK("000000", "OK."), //
    NOTFOUND("000001", "Resource Not Found"),
    REST_CLIENT_EXCEPTION("900000","RestClientExcpetion - Finnhub Service is unavailable"),
    NULL_POINTER_EXCEPTION("900002","NPE"),
    WRONG_INPUT_SYMBOL("900004","Wrong Input Stock Symbol, please try again."),
    GENERAL_EXCEPTION("900003","AllArgurmentException");


    private String code;
    private String message;
  
}
