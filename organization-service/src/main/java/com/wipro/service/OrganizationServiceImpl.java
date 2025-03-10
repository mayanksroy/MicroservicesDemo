package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.OrganizationDto;
import com.wipro.entity.Organization;
import com.wipro.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public OrganizationDto saveOrganization(OrganizationDto dto) {
		Organization organization = mapper.map(dto, Organization.class);
		Organization savedOrganization = orgRepo.save(organization);
		return mapper.map(savedOrganization, OrganizationDto.class);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String orgCode) {
		Organization existingOrganization = orgRepo.findByOrgCode(orgCode);
		return mapper.map(existingOrganization, OrganizationDto.class);
	}
}
