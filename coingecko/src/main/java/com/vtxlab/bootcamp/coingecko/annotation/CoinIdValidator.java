package com.vtxlab.bootcamp.coingecko.annotation;

import java.util.List;
import java.util.Objects;
import com.vtxlab.bootcamp.coingecko.infra.CoinId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoinIdValidator implements ConstraintValidator<CoinIdCheck, List<String>>{

    @Override
    public boolean isValid(List<String> dto, ConstraintValidatorContext context){
        try {
            boolean validCoinId = true;
            //List<String> str = dto.get();
            for (int i=0; i<dto.size(); i++){
                if (!(dto.get(i).equals(CoinId.BITCOIN.getName()) || dto.get(i).equals(CoinId.ETHEREUM.getName()))){
                    validCoinId = false;
                    break;
                }
            }
            return Objects.nonNull(dto) && validCoinId;
        } catch (NumberFormatException e){
            return false;
        }
    }
    
}