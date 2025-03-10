package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.DepartmentDto;
import com.wipro.entity.Department;
import com.wipro.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto dto) {
		// TODO Auto-generated method stub
		Department department = mapper.map(dto, Department.class);
		Department savedDepartment = deptRepo.save(department);
		return mapper.map(savedDepartment, DepartmentDto.class);
	}

	@Override
	public DepartmentDto getDepartmentByCode(String deptCode) {
		// TODO Auto-generated method stub
		Department existingDepartment = deptRepo.findByDeptCode(deptCode);
		return mapper.map(existingDepartment, DepartmentDto.class);
	}

}
