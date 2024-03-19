package com.vtx.bootcamp.productdata.dto.request;

import java.sql.Timestamp;
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
public class CryptoCoingeckoDTO {

  private String code;
  private String message;
  private List<Data> data;

  @Getter
  public static class Data{
    private String id;
    private String symbol;
    private String name;
    private String image;
    private double ath;
    private double atl;
    private Roi roi;
    private long fullyDilutedValuation;
    private double currentPrice;
    private long marketCap;
    private long marketCapRank;
    private long totalVolume;
    private double high24h;
    private double low24h;
    private double priceChange24h; 
    private double priceChangePercentage24h;
    private double marketCapChange24h;
    private double marketCapChangePercentage24h;
    private double circulatingSupply;
    private double totalSupply;
    private double maxSupply;
    private double athChangePercentage;
    private Timestamp athDate;
    private double atlChangePercentage;
    private Timestamp atlDate;
    private Timestamp lastUpdated;

    @Getter
    public static class Roi{
        
      private double times;
      private String currency;
      private double percentage;
    }
  }
}
