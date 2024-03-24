package com.vtxlab.bootcamp.dataservice.entity.coin;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "tproduct_coin_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoinEntity implements Serializable {

  @Id
  private Long id;
  private String coin_code;

  


  
}
