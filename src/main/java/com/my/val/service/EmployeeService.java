package com.my.val.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.my.val.entity.Employee;

@Service
public interface EmployeeService {
	
	public Employee findById(int id);
	
	public List<Employee> findAll();
	
	public Employee save(Employee employee);
	
	public void deleteById(int id);
}
