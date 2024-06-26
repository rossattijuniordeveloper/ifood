package com.tecnopar.ifood.cadastro.models;

import java.sql.Date;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant extends PanacheEntityBase {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;	
	
	public String tradeName;
	
	public String owner;
	
	public String document;
	
	@OneToOne(cascade = CascadeType.ALL)
	public Location location;
	
	@Schema(hidden =true)
	@CreationTimestamp
	public Date dataCriacao;
	
	@Schema(hidden =true)
	@UpdateTimestamp
	public Date dataAtualizacao;	

}
