package com.developers.choice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developers.choice.bo.EmployeeBO;
import com.developers.choice.grpc.HelloReply;
import com.developers.choice.grpc.HelloWorldClient;
import com.developers.choice.model.Employee;

//import com.developers.choice.bo.EmployeeBO;
//import com.developers.choice.model.Employee;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
@Api(value = "action controller", description = "Operations pertaining to employee")
public class ActionController {
	
	private static final Logger Logger =LoggerFactory.getLogger(ActionController.class);

	@Autowired
	private EmployeeBO employeeBO;

	@Autowired
	HelloWorldClient client;
	 
	@ApiOperation(value = "Get an employee by Id")
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployeeList() {
		List<Employee> list = employeeBO.getListOfEmployee();
		Logger.info("get employee : size : ", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<?> getEmployeeList(@RequestBody Employee employee) {
		List<Employee> list = employeeBO.addEmployee(employee);
		Logger.info("add employee : size : ", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<?> updateEmployeeList(@RequestBody Employee employee, @PathVariable long id) {
		List<Employee> list = employeeBO.addEmployee(employee);
		Logger.info("update employee : size : ", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
//	@RequestMapping(value="/updateOne", method=RequestMethod.PATCH) // 
	/**
	 *  both ways we can use
	 *  @RequestMapping or PathchMapping
	 * 
	 */

	@PatchMapping(value="/update")// this is just to testing purpose code
	public ResponseEntity<?> patchEmployeeList(@RequestBody List<Employee> employeeList) {
		List<Employee> finalList = new ArrayList<Employee>();
		for(Employee employee : employeeList) {
			finalList.addAll(employeeBO.updateEmployee(employee));
		}
		Logger.info("update patch employee : size : ", finalList.size());
		return new ResponseEntity<>(finalList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@RequestParam int employeeId) {
		List<Employee> list = employeeBO.removeEmployee(employeeId);
		Logger.info("delete  employee : size : ", list.size());
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value="/grpcName", method = RequestMethod.GET)
	public ResponseEntity<?> getNames(String name){
		HelloReply reply = null;
		try {
			reply = client.getNameData(name);
			Logger.info("reply: ", reply.getMessage());
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(reply, HttpStatus.OK);
	}
	
	
}
