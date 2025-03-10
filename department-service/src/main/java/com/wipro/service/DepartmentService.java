package com.wipro.service;

import com.wipro.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto dto);

	DepartmentDto getDepartmentByCode(String deptCode);

}
