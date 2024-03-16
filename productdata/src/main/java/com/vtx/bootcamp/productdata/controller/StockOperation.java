package com.vtx.bootcamp.productdata.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtx.bootcamp.productdata.dto.response.StockDTO;

public interface StockOperation {

  //http://localhost:8088/stocks/api/v2/add/stocks
  @PostMapping(value ="/add/stocks")
  ResponseEntity<String> addStock(@RequestBody List<StockDTO> stocksId);
  
  //http://localhost:8088/stocks/api/v2/delete/stocks?stock_id=AAPL
  @GetMapping(value = "/delete/stocks")
  ResponseEntity<String> deleteStock(@RequestParam(value="stock_id") List<String> stock_id);

}
