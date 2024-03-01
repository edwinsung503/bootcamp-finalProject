package com.vtxlab.bootcamp.fianlproject.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class CoingeckoDTO {

    private String id;
    private String symbol;
    private String name;
    private String image;
    private double current_price;
    @JsonProperty(value="currentPrice")
    public double getCurrent_Price(){
        return this.current_price;
    }
    private long market_cap;
    @JsonProperty(value="marketCap")
    public long getMarket_Cap(){
        return this.market_cap;
    }
    private long market_cap_rank;
    @JsonProperty(value="marketCapRank")
    public long getMarket_Cap_Rank(){
        return this.market_cap_rank;
    }
    private long fully_diluted_valuation;
    @JsonProperty(value="fullyDilutedValuation")
    public long getFully_Diluted_Valuation(){
        return this.fully_diluted_valuation;
    }
    private long total_volume;
    @JsonProperty(value="totalVolume")
    public long getTotal_Volume(){
        return this.total_volume;
    }
    private double high_24h;
    @JsonProperty(value="high24h")
    public double getHigh_24H(){
        return this.high_24h;
    }
    private double low_24h;
    @JsonProperty(value="low24h")
    public double getLow_24H(){
        return this.low_24h;
    }
    
    private double price_change_24h; 
    @JsonProperty(value="priceChange24h")
    public double getPrice_Change_24H(){
        return this.price_change_24h;
    }
    private double price_change_percentage_24h;
    @JsonProperty(value="priceChangePercentage24h")
    public double getPrice_Change_Percentage_24H(){
        return this.price_change_percentage_24h;
    }
    private double market_cap_change_24h;
    @JsonProperty(value="marketCapChange24h")
    public double getMarket_Map_Change_24H(){
        return this.market_cap_change_24h;
    }
    private double market_cap_change_percentage_24h;
    @JsonProperty(value="marketCapChangePercentage24h")
    public double getMarket_Cap_Change_Percentage_24H(){
        return this.market_cap_change_percentage_24h;
    }
    private double circulating_supply;
    @JsonProperty(value="circulatingSupply")
    public double getCirculating_Supply(){
        return this.circulating_supply;
    }
    private double total_supply;
    @JsonProperty(value="totalSupply")
    public double getTotal_Supply(){
        return this.total_supply;
    }
    private double max_supply;
    @JsonProperty(value="maxSupply")
    public double getMax_Supply() {
        return this.max_supply;
    }
    private double ath;
    private double ath_change_percentage;
    @JsonProperty(value="athChangePercentage")
    public double getAth_Change_Percentage(){
        return this.ath_change_percentage;
    }
    private String ath_date;
    @JsonProperty(value="athDate")
    public String getAth_Date(){
        return this.ath_date;
    }
    private double atl;
    private double atl_change_percentage;
    @JsonProperty(value="atlChangePercentage")
    public double getAtl_Change_Percentage(){
        return this.atl_change_percentage;
    }
    private String atl_date;
    @JsonProperty(value="atlDate")
    public String getAtl_Date(){
        return this.atl_date;
    }
    private Roi roi;
    
    private String last_updated;
    @JsonProperty(value="lastUpdated")
    public String getLast_Updated() {
        return this.last_updated;
    }
}
