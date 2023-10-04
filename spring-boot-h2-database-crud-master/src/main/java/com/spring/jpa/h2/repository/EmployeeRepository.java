package com.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.h2.entity.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}
