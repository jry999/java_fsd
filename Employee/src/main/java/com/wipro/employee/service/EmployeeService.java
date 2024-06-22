package com.wipro.employee.service;

import java.util.List;

import com.wipro.employee.model.Employee;

public interface EmployeeService {
	
	List<Employee> getAll();
	Employee getById(int id);
	List<Employee> getByWorkLocation(String location);
	List<Employee> getByFirstName(String firstName);
	String addNew(Employee emp);

}
