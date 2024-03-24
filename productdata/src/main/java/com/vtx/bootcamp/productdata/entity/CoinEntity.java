package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class CoinEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "coin_code")
  private String coinId;

  @OneToOne(mappedBy = "coinEntity")
  private CoinProductEntity coinProductEntity;

}
