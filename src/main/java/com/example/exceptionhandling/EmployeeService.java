package com.example.exceptionhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private static List<Employee> empList = new ArrayList<>();

	public void addEmployee(Employee employee) {
		empList.add(employee);
	}

	public List<Employee> getAllEmployees() {
			return empList.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
	}

	public void updateEmployee(Employee employee) {
		for(Employee emp : empList) {
			if(emp.getId()== employee.getId()) {
				emp.setName(employee.getName());
				emp.setSalary(employee.getSalary());
				break;
			}
			
		}
	}

	public void deleteEmployee(Long id) {
			Employee emp = empList.stream().filter(e->e.getId()==id).findFirst().get();
			empList.remove(emp);
	}

	public Employee getEmployeeById(Long id) {
		return empList.stream().filter(e->e.getId()==id).findFirst().get();
	}
	
	

}
