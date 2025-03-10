package com.wipro.service;

import com.wipro.dto.APIResponseDto;
import com.wipro.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto employeeDto);

	APIResponseDto getEmployeeById(Long id);

}
