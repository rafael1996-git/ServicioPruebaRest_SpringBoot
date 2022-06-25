package com.demo.prueba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.prueba.models.dao.IEmployeesDao;
import com.demo.prueba.models.dao.IJobsDao;
import com.demo.prueba.models.dao.IWorkedHoursDao;
import com.demo.prueba.models.entity.EmployeeWorkedHours;
import com.demo.prueba.models.entity.Employees;
import com.demo.prueba.models.entity.Jobs;

@Service
public class ServicesDaoImplement implements IServicesDao{

	@Autowired
	private IEmployeesDao EmployeesDao;
	
	@Autowired
	private IJobsDao JobsDao;
	@Autowired
	private IWorkedHoursDao WorkedHoursDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Employees> findAll() {
		return (List<Employees>) EmployeesDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Employees findById(Long id) {
		return EmployeesDao.findById(id).orElse(null);
	}


	@Override
	public Employees save(Employees empleado) {
		return EmployeesDao.save(empleado);
	}

	@Override
	public EmployeeWorkedHours save(EmployeeWorkedHours empleado) {
		return WorkedHoursDao.save(empleado);
	}


	@Override
	@Transactional(readOnly = true)
	public EmployeeWorkedHours findByEmployeeWorkedHours(Long id) {
		return WorkedHoursDao.findById(id).orElse(null);
	}


	@Override
	@Transactional(readOnly = true)
	public Jobs findByIdJobs(Long id) {
		return JobsDao.findById(id).orElse(null);
	}


	
	
}
