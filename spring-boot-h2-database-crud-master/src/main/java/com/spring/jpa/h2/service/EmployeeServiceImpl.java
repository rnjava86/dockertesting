package com.spring.jpa.h2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.spring.jpa.h2.entity.Employees;
import com.spring.jpa.h2.repository.EmployeeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repo;
    @Autowired
    ObjectMapper mapper;


    @Override
    public Employees saveEmployee(Employees employees) {
    	mapper.registerModule(new JavaTimeModule());
    	//mapper.constructType(employee);
        return repo.save(employees);
    }

    @Override
    public List<Employees> fetchAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employees updateEmployee(Employees employees) {
        Optional<Employees> emp=repo.findById(employees.getId());
        return repo.saveAndFlush(employees);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

    }
}
