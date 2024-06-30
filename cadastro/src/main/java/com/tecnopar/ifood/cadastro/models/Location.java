package com.tecnopar.ifood.cadastro.models;



import io.quarkus.panache.common.Sort.Column;
import jakarta.enterprise.inject.Default;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
		
	public Double latitude;
	
	public  Double longitude;
	
}
