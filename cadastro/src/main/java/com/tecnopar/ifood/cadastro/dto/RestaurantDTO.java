package com.tecnopar.ifood.cadastro.dto;

import com.tecnopar.ifood.cadastro.models.Restaurant;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RestaurantDTO {
	@NotNull
	@NotEmpty
	@Size(min= 3 , max= 30)
	public String tradeName;

	@NotNull
	@NotEmpty
	@Size(min = 3,max = 50)
	public String owner;
		
	@NotNull
	@Pattern( regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}" )
	public String document;	

	public LocationDTO location;

public boolean isValid(ConstraintValidatorContext constraintValidatorContext){
	constraintValidatorContext.disableDefaultConstraintViolation();
	if(Restaurant.find("document",document).count()>0){
		constraintValidatorContext.buildConstraintViolationWithTemplate("Documento já cadastrado")
			.addPropertyNode("Documento")
			.addConstraintViolation();
		return false;
	}
	return true;
}

}
