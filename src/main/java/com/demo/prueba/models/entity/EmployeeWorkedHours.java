package com.demo.prueba.models.entity;

import java.io.Serializable;
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
@Table(name = "horas_Trabajadas_Empleado")
public class EmployeeWorkedHours implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fecha_inicio;
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date fecha_fin;
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	@Column(unique = true,nullable = false)
	private Date fecha_trabajada;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado_id")
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	private Employees empleado;
	@NonNull
	@Column(unique = true,nullable = false)
	private Integer horas_trabajadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Date getFecha_trabajada() {
		return fecha_trabajada;
	}

	public void setFecha_trabajada(Date fecha_trabajada) {
		this.fecha_trabajada = fecha_trabajada;
	}

	public Employees getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employees empleado) {
		this.empleado = empleado;
	}

	public Integer getHoras_trabajadas() {
		return horas_trabajadas;
	}

	public void setHoras_trabajadas(Integer horas_trabajadas) {
		this.horas_trabajadas = horas_trabajadas;
	}

	public EmployeeWorkedHours(Long id, Date fecha_inicio, Date fecha_fin, Date fecha_trabajada, Employees empleado,
			Integer horas_trabajadas) {
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.fecha_trabajada = fecha_trabajada;
		this.empleado = empleado;
		this.horas_trabajadas = horas_trabajadas;
	}

	public EmployeeWorkedHours() {

	}

}
