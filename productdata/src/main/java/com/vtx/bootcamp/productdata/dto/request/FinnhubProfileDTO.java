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
public class FinnhubProfileDTO {
  
  private String code;
  private String message;
  private List<Data> data;

  @Getter
  public static class Data{

    private String country;
    private String currency;
    private String estimateCurrency;
    private String exchange;
    private String finnhubIndustry;
    private String ipo;
    private String logo;
    private double marketCapitalization;
    private String name;
    private String phone;
    private double shareOutstanding;
    private String ticker;
    private String weburl;
  }
}
