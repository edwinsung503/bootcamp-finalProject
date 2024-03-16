package com.vtx.bootcamp.productdata.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Syscode {
  OK("00000", "OK."),
  INVALID_RESPONSE("9","Invalid Input."),
  UNKNOWN_ERROR("0","Unknown Error");


  private String code;
  private String message;
}
