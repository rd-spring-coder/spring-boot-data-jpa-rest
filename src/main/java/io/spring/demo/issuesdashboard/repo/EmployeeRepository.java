package io.spring.demo.issuesdashboard.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.spring.demo.issuesdashboard.domain.Employee;

@RepositoryRestResource(collectionResourceRel = "employees", path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByFirstName(@Param("name") String name);
}
