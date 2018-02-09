package io.spring.demo.issuesdashboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.spring.demo.issuesdashboard.domain.Salary;

@RepositoryRestResource(collectionResourceRel="salaries", path="salaries")
public interface SalaryRepository extends JpaRepository<Salary, Integer>{

}
