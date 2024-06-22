package com.wipro.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.employee.dao.EmployeeRepository;
import com.wipro.employee.exception.ResourceNotFoundException;
import com.wipro.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employee> getAll() {
		List<Employee> empList =new ArrayList<>();
		empList =repo.findAll();
		return empList;
	}

	@Override
	public Employee getById(int id) {
		Optional<Employee> employee = repo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
	}

	@Override
	public List<Employee> getByWorkLocation(String location) {
		List<Employee> empListbyLoc =new ArrayList<>();
		empListbyLoc=repo.findByWorkLocation(location);
		if(empListbyLoc.size()!=0) {
		return empListbyLoc;
		}
		else {
			throw new ResourceNotFoundException("Employee not found with Work Location: " + location);
        
		}
	}

	@Override
	public List<Employee> getByFirstName(String firstName) {
		List<Employee> empListbyName =new ArrayList<>();
		empListbyName=repo.findByFirstName(firstName);
		if(empListbyName.size()!=0) {
			return empListbyName;
			}
			else {
				throw new ResourceNotFoundException("Employee not found with First Name: " + firstName);
	        
			}
	}

	@Override
	public String addNew(Employee emp) {
		repo.save(emp);
		return "Success";
	}

}
