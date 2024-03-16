package com.vtx.bootcamp.productdata.dto.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String stock_id;

}
