package com.my.val.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.my.val.entity.Employee;
import com.my.val.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class FrontController {	
		
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Employee> myemp = employeeService.findAll();
		model.addAttribute("emp", myemp);
		return "list";
	}
	
	@GetMapping("/addemp")
	public String Addemp(Model model) {
		model.addAttribute("employee", new Employee());
		return "addemp";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/home";
	}
	
	@GetMapping("/updateemp")
	public String updateform(@RequestParam("employeeId") int id, Model model) {
		Employee theemp = employeeService.findById(id);
		model.addAttribute("employee", theemp);
		return "addemp";	
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id, Model model) {
		employeeService.deleteById(id);
		return "redirect:/home";
	}
	
	
	
}
