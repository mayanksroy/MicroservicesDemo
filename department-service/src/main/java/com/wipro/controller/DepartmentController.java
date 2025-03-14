package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.DepartmentDto;
import com.wipro.service.DepartmentService;

@RestController
//@RefreshScope
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptService;
	
	@PostMapping
	private DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto)
	{
		return deptService.saveDepartment(departmentDto);
	}
	
	@GetMapping("{deptCode}")
	public DepartmentDto getDepartmentByCode(@PathVariable("deptCode") String deptCode)
	{
		return deptService.getDepartmentByCode(deptCode);
	}
}
