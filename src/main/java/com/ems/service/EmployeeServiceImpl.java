package com.ems.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ems.exception.GlobalExceptionHandler;
import com.ems.exception.ResourceNotFoundException;
import com.ems.model.Employee;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {//get listall employee
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public  Employee saveEmployee(Employee employee) {//add employee 
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	 public Optional<Employee> getEmployeeById(int id) {//get employee
        return employeeRepository.findById(id);
               
    }

	@Override
	public void deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
	    Pageable pageable = PageRequest.of(pageNo, pageSize);
	    return employeeRepository.findAll(pageable);
	}
	@Override
	public Employee updateEmployeeById(int id,Employee employee) {//update employee
		// TODO Auto-generated method stub
		Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        existing.setFirstname(employee.getFirstname());
        existing.setLastname(employee.getLastname());
        existing.setEmail(employee.getEmail());

        return employeeRepository.save(existing);
	}

	
	
	
	

}
