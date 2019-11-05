package com.developers.choice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developers.choice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
