package com.wipro.service;

import com.wipro.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto dto);

	OrganizationDto getOrganizationByCode(String orgCode);

}
