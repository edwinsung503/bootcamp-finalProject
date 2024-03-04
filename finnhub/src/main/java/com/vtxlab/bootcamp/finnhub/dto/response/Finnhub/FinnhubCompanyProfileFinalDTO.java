package com.vtxlab.bootcamp.finnhub.dto.response.Finnhub;

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
public class FinnhubCompanyProfileFinalDTO {
  
  private String code;
  private String message;
  @JsonProperty(value ="data")
  private List<FinnhubCompanyProfileDTO> finnhubCompanyProfileDTOs; 
}
