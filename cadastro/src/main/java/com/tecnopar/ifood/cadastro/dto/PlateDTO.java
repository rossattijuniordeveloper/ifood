package com.tecnopar.ifood.cadastro.dto;

import java.math.BigDecimal;

import com.tecnopar.ifood.cadastro.models.Restaurant;

//import jakarta.persistence.ManyToOne;

public class PlateDTO {

	public String name;
	
	public String description;

	public Restaurant restaurant;
	
	public BigDecimal price;
    
}
