package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	public Organization findByOrgCode(String orgCode);

}
