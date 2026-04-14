package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ems.model.Employee;

public interface EmployeeService {

	Optional  getEmployeeById(int id);
	List<Employee> getAllEmployees();
	 Employee saveEmployee(Employee employee);
	 Employee updateEmployeeById(int id,Employee employee);
	  void deleteEmployeeById(int id);
	Page<Employee> findPaginated(int pageNo, int pageSize);
	List<Employee> getEmployeeSorted(String sortBy,String direction);
	List<Employee> searchEmployees(String keyword);
}
