package com.developers.choice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.developers.choice.bo.EmployeeBO;
import com.developers.choice.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "action controller", description = "Operations pertaining to employee")
public class ActionController {

	@Autowired
	private EmployeeBO employeeBO;
	 
	@ApiOperation(value = "Get an employee by Id")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployeeList() {
		List<Employee> list = employeeBO.getListOfEmployee();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> getEmployeeList(@RequestBody Employee employee) {
		List<Employee> list = employeeBO.addEmployee(employee);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> updateEmployeeList(@RequestBody Employee employee, @PathVariable long id) {
		List<Employee> list = employeeBO.addEmployee(employee);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
//	@RequestMapping(value="/updateOne", method=RequestMethod.PATCH) // 
	/**
	 *  both ways we can use
	 *  @RequestMapping or PathchMapping
	 * 
	 */

	@PatchMapping(value="/update")
	public ResponseEntity<?> patchEmployeeList(@RequestBody List<Employee> employeeList) {
		List<Employee> finalList = new ArrayList<Employee>();
		for(Employee employee : employeeList) {
			finalList.addAll(employeeBO.updateEmployee(employee));
		}
		return new ResponseEntity<>(finalList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@RequestBody Employee employee) {
		List<Employee> list = employeeBO.addEmployee(employee);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
