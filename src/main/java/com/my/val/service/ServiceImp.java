package com.my.val.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.val.entity.Employee;
import com.my.val.repository.EmployeeRepository;


@Service
public class ServiceImp implements EmployeeService{
	
	@Autowired
	public EmployeeRepository employeeRepository;
	

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	
	@Override
	public Employee findById(int id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		Employee theemp= null;
		
		if(emp.isPresent()) {
			theemp = emp.get();
		}
		return theemp;
	}


	@Override
	public Employee save(Employee employee) {
		
		return employeeRepository.save(employee);
	}


	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}





}
