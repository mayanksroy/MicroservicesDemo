package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.wipro.dto.APIResponseDto;
import com.wipro.dto.DepartmentDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.dto.OrganizationDto;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper mapper;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Autowired
//	private WebClient webClient;
	
	@Autowired
	private APIClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto Dto) {
		// TODO Auto-generated method stub
		Employee employee = mapper.map(Dto, Employee.class);
		Employee savedEmployee = empRepo.save(employee);
		return mapper.map(savedEmployee, EmployeeDto.class);
	}

//	public APIResponseDto getEmployeeById(Long id) {
//		Employee employee = empRepo.findById(id).get();
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/departments/"+employee.getDeptCode(), DepartmentDto.class);
//		DepartmentDto departmentDto = responseEntity.getBody();
//		EmployeeDto employeeDto =  mapper.map(employee, EmployeeDto.class);
//		APIResponseDto apiresponseDto = new APIResponseDto();
//		apiresponseDto.setDepartmentDto(departmentDto);
//		apiresponseDto.setEmployeeDto(employeeDto);
//		return apiresponseDto;
//	}
	
	//Communication using WebClient
//	public APIResponseDto getEmployeeById(Long id) {
//		Employee employee = empRepo.findById(id).get();		
//		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/departments/"+employee.getDeptCode()).retrieve().bodyToMono(DepartmentDto.class).block();
//		EmployeeDto employeeDto =  mapper.map(employee, EmployeeDto.class);
//		APIResponseDto apiresponseDto = new APIResponseDto();
//		apiresponseDto.setDepartmentDto(departmentDto);
//		apiresponseDto.setEmployeeDto(employeeDto);
//		return apiresponseDto;
//	}
	
//	//Communication using WebClient and using CircuitBreaker
//	@Override
//	//@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
//	@Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
//	public APIResponseDto getEmployeeById(Long id) {
//		System.out.println("iam in getEmployeeById");
//		Employee employee = empRepo.findById(id).get();		
//		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/departments/"+employee.getDeptCode()).retrieve().bodyToMono(DepartmentDto.class).block();
//		EmployeeDto employeeDto =  mapper.map(employee, EmployeeDto.class);
//		APIResponseDto apiresponseDto = new APIResponseDto();
//		apiresponseDto.setDepartmentDto(departmentDto);
//		apiresponseDto.setEmployeeDto(employeeDto);
//		return apiresponseDto;
//	}
	
	//Communication using OpenFeign and Server Registry
	@Override
	@CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	
	public APIResponseDto getEmployeeById(Long id) {
		System.out.println("Getting Output!!");
		Employee existingEmployee = empRepo.findById(id).get();
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("X-B3-TraceId", MDC.get("traceId"));
	    headers.add("X-B3-SpanId", MDC.get("spanId"));
		
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(existingEmployee.getDeptCode(), headers);
		OrganizationDto organizationDto = apiClient.getOrganizationByCode(existingEmployee.getOrgCode(), headers);
		EmployeeDto employeeDto =  mapper.map(existingEmployee, EmployeeDto.class);
		
		APIResponseDto apiresponseDto = new APIResponseDto();
		apiresponseDto.setDepartmentDto(departmentDto);
		apiresponseDto.setOrganizationDto(organizationDto);
		apiresponseDto.setEmployeeDto(employeeDto);
		return apiresponseDto;
	}
	
	public APIResponseDto getDefaultDepartment(Long id, Exception exception) {
		Employee employee = empRepo.findById(id).get();	
		
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDeptName("Default Dept");
		departmentDto.setDeptDesc("Fallback Department");
		departmentDto.setDeptCode("D01");
		
		OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setOrgName("Default Org");
        organizationDto.setOrgDesc("Fallback Organization");
        organizationDto.setOrgCode("ORG01");
		
		EmployeeDto employeeDto =  mapper.map(employee, EmployeeDto.class);
		
		APIResponseDto apiresponseDto = new APIResponseDto();
		apiresponseDto.setDepartmentDto(departmentDto);
		apiresponseDto.setOrganizationDto(organizationDto);
		apiresponseDto.setEmployeeDto(employeeDto);
		return apiresponseDto;
	}

}
