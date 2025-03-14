package com.wipro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.wipro.dto.DepartmentDto;
import com.wipro.dto.OrganizationDto;

//@FeignClient(url = "http://localhost:8080", value = "department-service")
//@FeignClient(name = "department-service")
@FeignClient(name = "api-gateway")

public interface APIClient {

	@GetMapping("/department-service/departments/{deptCode}")
	public DepartmentDto getDepartmentByCode(@PathVariable("deptCode") String deptCode, @RequestHeader HttpHeaders headers);
	
	@GetMapping("/organization-service/organizations/{orgCode}")
	public OrganizationDto getOrganizationByCode(@PathVariable("orgCode") String orgCode, @RequestHeader HttpHeaders headers);
	
}