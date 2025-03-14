package com.wipro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String deptCode;
	private String orgCode;
	
}
