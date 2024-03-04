package com.vtxlab.bootcamp.finnhub.annotation;

import java.util.Objects;
import com.vtxlab.bootcamp.finnhub.dto.request.StockIdDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StockIdValidator implements ConstraintValidator<StockIdCheck,StockIdDTO> {
  
  @Override
  public boolean isValid(StockIdDTO dto, ConstraintValidatorContext context){
    try {
      boolean onlyLetter = true;
      String word = dto.getSymbol();
      for (int i=0; i< word.length(); i++){
        char c = word.charAt(i);
        if (!Character.isLetter(c)){
          onlyLetter =  false;
          break;
        }
      }
      return Objects.nonNull(dto) && dto.getSymbol().length() > 0  && onlyLetter;
    } catch (NumberFormatException e) {
        return false;
    }
  }
}
