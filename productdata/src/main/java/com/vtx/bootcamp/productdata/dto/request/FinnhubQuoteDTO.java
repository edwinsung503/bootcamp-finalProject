package com.vtx.bootcamp.productdata.dto.request;

import java.util.List;
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
public class FinnhubQuoteDTO {
  
  private String code;
  private String message;
  private List<Data> data;

  @Getter
  public static class Data{
    private double c;
    private double d;
    private double dp;
    private double h;
    private double l;
    private double o;
    private double pc;
    private double t;
  }
}
