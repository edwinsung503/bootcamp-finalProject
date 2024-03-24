package com.vtxlab.bootcamp.dataservice.dto.response;

import java.sql.Timestamp;
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
public class RedisProductResponseDTO {

  private String productId;
  private Timestamp trade_date;
  private double day_high;
  private double day_low;
  private double day_open;
  private double day_end;
  
}
