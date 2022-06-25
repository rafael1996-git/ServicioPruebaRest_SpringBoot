package com.demo.prueba.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "genero")
public class Genders implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre_genero;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre_genero() {
		return nombre_genero;
	}


	public void setNombre_genero(String nombre_genero) {
		this.nombre_genero = nombre_genero;
	}


	public Genders(Long id, String nombre_genero) {
		this.id = id;
		this.nombre_genero = nombre_genero;
	}


	public Genders() {
		
	}
	
	
}
