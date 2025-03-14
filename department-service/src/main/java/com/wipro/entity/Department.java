package com.wipro.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity @Builder
@Table(name = "departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String deptName;
	private String deptDesc;
	private String deptCode;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getDeptName() {
//		return deptName;
//	}
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//	public String getDeptDesc() {
//		return deptDesc;
//	}
//	public void setDeptDesc(String deptDesc) {
//		this.deptDesc = deptDesc;
//	}
//	public String getDeptCode() {
//		return deptCode;
//	}
//	public void setDeptCode(String deptCode) {
//		this.deptCode = deptCode;
//	}
}
