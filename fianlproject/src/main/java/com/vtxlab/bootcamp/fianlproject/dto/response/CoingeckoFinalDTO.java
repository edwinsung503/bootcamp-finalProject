package com.vtxlab.bootcamp.fianlproject.dto.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vtxlab.bootcamp.fianlproject.infra.Syscode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoingeckoFinalDTO {
    
    private String code;
    private String message;
    @JsonProperty(value ="data")
    private List<CoingeckoDTO> coingeckoDTO; 
}
