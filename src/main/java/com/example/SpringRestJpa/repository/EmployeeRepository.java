package com.example.SpringRestJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringRestJpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
