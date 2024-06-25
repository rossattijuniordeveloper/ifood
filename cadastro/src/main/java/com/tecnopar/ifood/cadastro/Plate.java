package com.tecnopar.ifood.cadastro;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "plate")
public class Plate extends PanacheEntityBase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String name;
	
	public String description;
	
	@ManyToOne
	public Restaurant restaurant;
	
	public BigDecimal price;
	
	@CreationTimestamp	
	public Date dataCriacao;
	
	@UpdateTimestamp
	public Date dataAtualizacao;	
	
}
