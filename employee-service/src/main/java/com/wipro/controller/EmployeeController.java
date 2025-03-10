package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.APIResponseDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.service.EmployeeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "Operations related to employees")
public class EmployeeController {
	@Autowired
	public EmployeeService empService;
	
	@PostMapping
	private EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return empService.saveEmployee(employeeDto);
	}
	
	@GetMapping("{id}")
	public APIResponseDto getEmployeeById(@PathVariable("id") Long id)
	{
		return empService.getEmployeeById(id);
	}
}
