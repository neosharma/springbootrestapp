package com.neohacks.myrestapp.service;

import org.springframework.data.repository.CrudRepository;

import com.neohacks.myrestapp.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}

