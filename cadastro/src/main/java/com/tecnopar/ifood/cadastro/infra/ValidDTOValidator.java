package com.tecnopar.ifood.cadastro.infra;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidDTOValidator implements ConstraintValidator<ValidDTO, DTO> {

    @Override
    public void initialize(ValidDTO constraintAnnotation) {
       }

    @Override
    public boolean isValid(DTO value, ConstraintValidatorContext context) {
      return value.isValid(context);
    }
    
    
}
