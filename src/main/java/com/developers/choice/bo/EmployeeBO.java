package com.developers.choice.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.developers.choice.model.Employee;

@Service
public class EmployeeBO {
	
	private static Map<Integer, List<Employee>> resultMap = new HashMap<>();
	private static int counter = 0;

	public List<com.developers.choice.model.Employee> getListOfEmployee(){
		List<Employee> list = new ArrayList<>();
		resultMap.forEach((k, v)->{
			list.addAll(v);
		});
		return list;
	}
	public List<Employee> addEmployee(Employee employee){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);
		resultMap.put(++counter, employeeList);
		
		List<Employee> list = new ArrayList<>();
		resultMap.forEach((k, v)->{
			list.addAll(v);
		});
		return list;
	}
	public List<Employee> updateEmployee(Employee employee){
		
		Integer empId = (int) employee.getId();
		List<Employee> list = resultMap.get(empId);
		List<Employee> finalList = new ArrayList<Employee>();
		for(Employee emp : list) {
			
			if(employee.getName() != null) {
				emp.setName(employee.getName());
			}
			if(employee.getDept() != null) {
				emp.setDept(employee.getDept());
			}
			finalList.add(employee);
		}
		resultMap.put(empId, finalList);
		
		List<Employee> responseList = new ArrayList<>();
		resultMap.forEach((k, v)->{
			responseList.addAll(v);
		});
		return responseList;
	}
	public List<Employee> removeEmployee(int employeeId){
		
		resultMap.remove(employeeId);
		List<Employee> responseList = new ArrayList<>();
		resultMap.forEach((k, v)->{
			responseList.addAll(v);
		});
		return responseList;
	}
}
