package com.developers.choice.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developers.choice.model.Employee;

@Service
public class EmployeeBO {

	@Autowired
	private com.developers.choice.repository.EmployeeRepository employeeData;

	public List<com.developers.choice.model.Employee> getListOfEmployee(){
		List<Employee> list = employeeData.findAll();
		return list;
	}
	public List<Employee> addEmployee(Employee employee){
		employeeData.save(employee);
		List<Employee> list = employeeData.findAll();
		return list;
	}
	public List<Employee> updateEmployee(Employee employee){
		Optional<Employee> newEmpList = employeeData.findById(employee.getId());
		Employee newEmp = newEmpList.get();
//		newEmp.setDept(employee.getDept());
		newEmp.setName(employee.getName());
		
		employeeData.save(newEmp);
		List<Employee> list = employeeData.findAll();
		return list;
	}
}
