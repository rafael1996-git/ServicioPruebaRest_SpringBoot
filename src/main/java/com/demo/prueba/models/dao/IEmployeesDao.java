package com.demo.prueba.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.prueba.models.entity.Employees;


public interface IEmployeesDao extends CrudRepository<Employees, Long>{
	
	@Query(value = "select * from empleados  where trabajo_id=?1", nativeQuery = true)
	public List<Employees>  findByEmpleado(Long id);
	

}
