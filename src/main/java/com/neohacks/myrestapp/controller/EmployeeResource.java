package com.neohacks.myrestapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neohacks.myrestapp.entity.Employee;
import com.neohacks.myrestapp.service.EmployeeRepository;

@RestController
@RequestMapping(path="/employee")
public class EmployeeResource {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//GetAllEmployee
	@GetMapping(path="")
	public @ResponseBody List<Employee> getAllEmployee(){
		List<Employee> employeeList = new ArrayList<Employee>();
		for(Employee employee : employeeRepository.findAll()) {
			employeeList.add(employee);
		}
		return employeeList;
	}
	
	//GetEmployee By Id
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Employee> getEmployee(@PathVariable("id") Integer id){
		return employeeRepository.findById(id);
	}
	
	//Create New Employee
	@PostMapping(path="")
	public @ResponseBody String addEmployee(@RequestBody Employee employee) {	
		employeeRepository.save(employee);
		return "Employee Created.";
	}
	
	//Update Employee
	@PutMapping(path="/{id}")
	public @ResponseBody String updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
		employee.setId(id);
		employeeRepository.save(employee);
		return "Employee Updated.";
	}
}
