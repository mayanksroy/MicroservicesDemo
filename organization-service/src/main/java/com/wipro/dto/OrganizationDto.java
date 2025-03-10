package com.wipro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
public class OrganizationDto {
	private Long id;
	private String orgName;
	private String orgDesc;
	private String orgCode;
	
}
