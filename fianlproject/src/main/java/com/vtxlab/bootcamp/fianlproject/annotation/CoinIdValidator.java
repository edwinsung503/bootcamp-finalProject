package com.vtxlab.bootcamp.fianlproject.annotation;

import java.util.Objects;
import com.vtxlab.bootcamp.fianlproject.dto.request.CoinIdDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoinIdValidator implements ConstraintValidator<CoinIdCheck, CoinIdDTO>{

    @Override
    public boolean isValid(CoinIdDTO dto, ConstraintValidatorContext context){
        try {
            return Objects.nonNull(dto) && dto.getId().toString().equals("bitcoin");
        } catch (NumberFormatException e){
            return false;
        }
    }
    
}
