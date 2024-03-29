package com.vtx.bootcamp.productdata.controller.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtx.bootcamp.productdata.controller.StockOperation;
import com.vtx.bootcamp.productdata.service.StockService;

@RestController
@RequestMapping(value = "stocks/api/v2")
public class StockController implements StockOperation{

  @Autowired
  private StockService stockService;
  
  @Override
  public ResponseEntity<String> addStock(@RequestBody List<String> stocksId){
    stockService.addStock(stocksId);
   return new ResponseEntity<>("Stocks added successfully", HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<String> deleteStock(@RequestParam List<String> stock_id){
    stockService.deleteStock(stock_id);
    return new ResponseEntity<>("Stocks deteled successfully", HttpStatus.CREATED);
  }
}
