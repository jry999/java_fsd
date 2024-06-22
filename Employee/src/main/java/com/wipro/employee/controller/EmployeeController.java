package com.wipro.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employee.model.Employee;
import com.wipro.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@GetMapping("/")
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id){
		
		return ResponseEntity.ok(service.getById(id));
		
	}
	
	@GetMapping("/byWorkLocation/{byWorkLocation}")
	public ResponseEntity<List<Employee>> getByWorkLocation(@PathVariable String byWorkLocation){
		return ResponseEntity.ok(service.getByWorkLocation(byWorkLocation));
		
	}
	@GetMapping("/byName/{byName}")
	public ResponseEntity<List<Employee>> getByFirstName(@PathVariable String byName){
		return ResponseEntity.ok(service.getByFirstName(byName));
	}
	@PostMapping("/")
	public ResponseEntity<String> addNew(@RequestBody Employee emp){
		
		String newEmp =service.addNew(emp);
		return ResponseEntity.ok(newEmp);
		
	}

}
