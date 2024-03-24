package com.vtx.bootcamp.productdata.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tproduct_stock_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockEntity implements Serializable{

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "stock_code") // Assuming your column name is 'stock_id'
  private String stockId; // Changed variable name to camelCase

  @OneToOne(mappedBy = "stockEntity")
  private StockProductEntity stockProductEntity;

  @OneToMany(mappedBy = "stockEntities")
  private List<StockDailyProductEntity> stockDailyProductEntities = new ArrayList<>();
  
}
