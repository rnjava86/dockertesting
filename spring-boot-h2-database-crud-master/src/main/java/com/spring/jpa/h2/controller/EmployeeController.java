package com.spring.jpa.h2.controller;

import com.spring.jpa.h2.entity.Employees;
import com.spring.jpa.h2.repository.EmployeeRepository;
import com.spring.jpa.h2.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(path = "/emp")
public class EmployeeController
{
    //https://www.geeksforgeeks.org/spring-boot-jparepository-with-example/
    /*
    Need to compare Department with Emaploy need to implement same.
     */
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired(required=false)
    private EmployeeService employeeService;

    @GetMapping(path="/", produces = "application/json")
    public List<Employees> getEmployees()
    {
        return employeeService.fetchAllEmployee();
    }

    @PostMapping(path= "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employees employee) {

        //add resource by service
//        employeeDao.addEmployee(employee);
        employeeService.saveEmployee(employee);
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
