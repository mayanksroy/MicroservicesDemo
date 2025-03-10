package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.OrganizationDto;
import com.wipro.service.OrganizationService;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
	
	@Autowired
	private OrganizationService orgService;
	
	@PostMapping
	private OrganizationDto saveOrganization(@RequestBody OrganizationDto organizationDto)
	{
		return orgService.saveOrganization(organizationDto);
	}
	
	@GetMapping("{orgCode}")
	public OrganizationDto getOrganizationByCode(@PathVariable("orgCode") String orgCode)
	{
		return orgService.getOrganizationByCode(orgCode);
	}
}
