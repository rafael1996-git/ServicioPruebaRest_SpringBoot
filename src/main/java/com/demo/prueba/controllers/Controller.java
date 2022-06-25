package com.demo.prueba.controllers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.prueba.models.dao.IEmployeesDao;
import com.demo.prueba.models.dao.IWorkedHoursDao;
import com.demo.prueba.models.entity.EmployeeWorkedHours;
import com.demo.prueba.models.entity.Employees;
import com.demo.prueba.models.entity.Jobs;
import com.demo.prueba.services.IServicesDao;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class Controller {


	@Autowired
	private IServicesDao clienteService;

	@Autowired
	private IEmployeesDao EmployeesDao;

	@Autowired
	private IWorkedHoursDao WorkedHoursDao;

	@GetMapping("/empleado/{id}")
	public ResponseEntity<?> getID(@PathVariable Long id) {
		Employees empleado = null;
		Map<String, Object> response = new HashMap<>();

		try {

			empleado = clienteService.findById(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error del servidor contacte ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (empleado == null) {
			response.put("mensaje", "No hay Registros en la base de datos!");
			response.put("NOT_FOUND", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("employees", empleado);
		response.put("success", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/Cargoempleado/{id}")
	public ResponseEntity<?> getCargo(@PathVariable Long id) {
		List<Employees> empleado = null;
		Map<String, Object> response = new HashMap<>();

		try {

			empleado = EmployeesDao.findByEmpleado(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error del servidor contacte ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (empleado == null || empleado.isEmpty()) {
			response.put("mensaje", "No hay Registros en la base de datos!");
			response.put("NOT_FOUND", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("employees", empleado);
		response.put("success", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/empleados")
	public ResponseEntity<?> All() {
		List<Employees> empleado = null;
		Map<String, Object> response = new HashMap<>();

		try {

			empleado = clienteService.findAll();

		} catch (DataAccessException e) {
			response.put("mensaje", "Error del servidor contacte ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (empleado == null) {
			response.put("mensaje", "No hay Registros en la base de datos!");
			response.put("NOT_FOUND", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("employees", empleado);
		response.put("success", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/empleado")
	public ResponseEntity<?> create(@RequestBody Employees empleado) throws ParseException {
		Employees clientenew = null;
		Map<String, Object> response = new HashMap<>();
		String date1 = empleado.getFecha_nacimiento().toString();
		String año = date1.substring(24, 28);
		Period edad = Period.between(LocalDate.of(Integer.parseInt(año), 1, 1), LocalDate.now());
		if (edad.getYears() < 18) {
			response.put("mensaje", "Debes tener mayor a 18 años");
			response.put("Error ", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}

		try {
			clientenew = clienteService.save(empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al relizar el insert de la base de datos ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("empleado_id", clientenew.getId());
		response.put("success", "El empleado ah sido creado con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@PostMapping("/horaTrabajadaEmpleado")
	public ResponseEntity<?> saveHoraTrabajada(@RequestBody EmployeeWorkedHours empleado) throws ParseException {
		EmployeeWorkedHours empleadow = null;
		Map<String, Object> response = new HashMap<>();
		Date date_of_today = new Date();

		// Use toString() to print the date
		System.out.println(date_of_today.toString());
		System.out.println(empleado.getHoras_trabajadas().toString());

		if (empleado.getFecha_trabajada().after(date_of_today)) {
			response.put("mensaje", " Error la fecha debe ser menor oh igual a la fecha concurrida:!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		} else if (empleado.getHoras_trabajadas() > 20) {
			response.put("mensaje", " Error no puede exceder a las 20 horas del trabajo laboral!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			empleadow = clienteService.save(empleado);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al relizar el insert de la base de datos ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("total_worked_hours", empleadow.getHoras_trabajadas());
		response.put("success", "El registro ah sido creado con exito");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@GetMapping("/totalHorasEmpleado/{fecha_inicio}/{fecha_final}/{id}")
	public ResponseEntity<?> HorasEmpleado(@PathVariable Long id, @PathVariable String fecha_inicio,
			@PathVariable String fecha_final) {
		EmployeeWorkedHours empleado = null;
		long horasDias = 0;
		int HorasLaborales = 0;
		Map<String, Object> response = new HashMap<>();
		LocalDate dateBefore = LocalDate.parse(fecha_inicio);
		LocalDate dateAfter = LocalDate.parse(fecha_final);
		if (dateBefore.isAfter(dateAfter)) {
			response.put("mensaje", " Error la fecha debe ser menor a la fecha final:!");
			response.put("BAD_REQUEST", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			horasDias = noOfDaysBetween;
			HorasLaborales = (int) (horasDias * 8);

			empleado = clienteService.findByEmployeeWorkedHours(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error del servidor contacte ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (empleado == null) {
			response.put("mensaje", "No hay Registros en la base de datos!");
			response.put("NOT_FOUND", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		response.put("total_worked_hours", HorasLaborales + " Horas laborales por un rango de 8 horas por dia");
		response.put("success", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/totalPagadoEmpleado/{fecha_inicio}/{fecha_final}/{id}")
	public ResponseEntity<?> pagoEmpleado(@PathVariable Long id, @PathVariable String fecha_inicio,
			@PathVariable String fecha_final) {
		EmployeeWorkedHours empleado = null;
		Jobs tipoEmpleo = null;
		long horasDias = 0;
		int Total = 0;
		int dato;
		Map<String, Object> response = new HashMap<>();
		LocalDate dateBefore = LocalDate.parse(fecha_inicio);
		LocalDate dateAfter = LocalDate.parse(fecha_final);
		if (dateBefore.isAfter(dateAfter)) {
			response.put("mensaje", " Error la fecha debe ser menor a la fecha final:!");
			response.put("BAD_REQUEST", HttpStatus.BAD_REQUEST);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		try {

			empleado = clienteService.findByEmployeeWorkedHours(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error del servidor contacte ");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			response.put("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		if (empleado == null) {
			response.put("mensaje", "No hay Registros en la base de datos!");
			response.put("NOT_FOUND", HttpStatus.NOT_FOUND);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		}
		dato = WorkedHoursDao.findBySalario(id);
		tipoEmpleo = clienteService.findByIdJobs(id);
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		horasDias = noOfDaysBetween;

		Total = (int) (horasDias * dato);
		response.put("payment",
				"" + tipoEmpleo.getNombre() + " $ " + Total + " Total salario por un rango de 8 horas por dia");
		response.put("success", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
