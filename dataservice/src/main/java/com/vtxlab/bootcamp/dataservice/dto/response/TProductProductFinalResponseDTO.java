package com.vtxlab.bootcamp.dataservice.dto.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TProductProductFinalResponseDTO {

  private String code;
  private String message;
  @JsonProperty(value ="data")
  private List<TProductProductResponseDTO> tProductCombineResponseDTOs;
  
}
