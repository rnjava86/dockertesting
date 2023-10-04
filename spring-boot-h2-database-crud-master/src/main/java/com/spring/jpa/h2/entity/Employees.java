package com.spring.jpa.h2.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    @JsonFormat
    private LocalDate birthDate;
    @Column
    private LocalDateTime joinedDate;
    @Column
    private Double salary;

    public Employees(long id, String name, LocalDate birthDate, LocalDateTime joinedDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.joinedDate = joinedDate;
    }

    public Employees() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        birthDate = birthDate;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDateTime joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employees)) return false;
        Employees employees = (Employees) o;
        return id == employees.id && Objects.equals(name, employees.name) && Objects.equals(birthDate, employees.birthDate) && Objects.equals(joinedDate, employees.joinedDate) && Objects.equals(salary, employees.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, joinedDate, salary);
    }

}
