package com.demo.prueba.models.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.prueba.models.entity.EmployeeWorkedHours;

public interface IWorkedHoursDao  extends CrudRepository<EmployeeWorkedHours, Long>{

	@Transactional(readOnly = true)
	@Query(value = "select * from horas_Trabajadas_Empleado  where empleado_id=?1", nativeQuery = true)
	public String  findByEmpleado(Long id);
	@Transactional(readOnly = true)
	@Query(value = "SELECT t.salario  FROM trabajos t,horas_trabajadas_empleado h WHERE t.id=h.id and h.empleado_id=?1", nativeQuery = true)
	public int findBySalario(Long id);
	

	
	
}
