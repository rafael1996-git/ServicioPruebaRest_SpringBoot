package com.demo.prueba.models.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.lang.NonNull;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "empleados")
public class Employees implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Column(unique = true,nullable = false)
	private String nombre;
	@NonNull
	@Column(unique = true,nullable = false)
	private String apellido;
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(unique = true,nullable = false)
	private Date fecha_nacimiento;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "genero_id")
	@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
	private Genders genero;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "trabajo_id")
	@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
	private Jobs trabajo;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Genders getGenero() {
		return genero;
	}

	public void setGenero(Genders genero) {
		this.genero = genero;
	}

	public Jobs getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Jobs trabajo) {
		this.trabajo = trabajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFecha_nacimiento() throws ParseException {
		

		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	

	public Employees(Long id, String nombre, String apellido, Date fecha_nacimiento, Genders genero, Jobs trabajo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_nacimiento = fecha_nacimiento;
		this.genero = genero;
		this.trabajo = trabajo;
	}

	public Employees() {
		
	}
	

	
	


}
