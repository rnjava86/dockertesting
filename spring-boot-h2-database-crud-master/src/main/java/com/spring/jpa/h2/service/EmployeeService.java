package com.spring.jpa.h2.service;

import java.util.List;

import com.spring.jpa.h2.entity.Employees;

public interface EmployeeService {

    public Employees saveEmployee(Employees employees);

    public List<Employees> fetchAllEmployee();

    public Employees updateEmployee(Employees employees);

    public void deleteEmployee(Long employeeId);


}
