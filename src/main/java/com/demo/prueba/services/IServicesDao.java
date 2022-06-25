package com.demo.prueba.services;

import java.util.List;

import com.demo.prueba.models.entity.EmployeeWorkedHours;
import com.demo.prueba.models.entity.Employees;
import com.demo.prueba.models.entity.Jobs;


public interface IServicesDao {

	public List<Employees> findAll();
	public Employees  findById(Long id);
	public Employees save(Employees empleado);
	public EmployeeWorkedHours save(EmployeeWorkedHours empleado);
	public EmployeeWorkedHours findByEmployeeWorkedHours(Long id);
	public Jobs  findByIdJobs(Long id);

}
