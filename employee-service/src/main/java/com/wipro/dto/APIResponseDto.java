package com.wipro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Data @Builder
public class APIResponseDto {
	
	private EmployeeDto employeeDto;
	private DepartmentDto departmentDto;
	private OrganizationDto organizationDto;
}
