package io.spring.demo.issuesdashboard.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "emp_no")
	private Integer empNo;

	private String firstName;

	private String lastName;

	@Temporal(TemporalType.DATE)
	@Past
	private Date birthDate;

	@Temporal(TemporalType.DATE)
	private Date hireDate;

	private Gender gender;

	@JsonBackReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Salary> salaries = new ArrayList<>();

	@JsonBackReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Title> titles = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity=DeptEmp.class)
	private Set<DeptEmp> deptEmps = new HashSet<>();

	public Set<DeptEmp> getDepartments() {
		return deptEmps;
	}

	public void setDepartments(Set<DeptEmp> departments) {
		this.deptEmps = departments;
	}

	public Employee() {
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	// utility methods to add employee to salary object
	public void addSalary(Salary salary) {
		this.salaries.add(salary);
		salary.setEmployee(this);
	}

	// utility methods to remove employee from salary object
	public void removeSalary(Salary salary) {
		this.salaries.remove(salary);
		salary.setEmployee(null);
	}

	// utility methods to add employee to salary object
	public void addTitle(Title title) {
		this.titles.add(title);
		title.setEmployee(this);
	}

	// utility methods to remove employee from salary object
	public void removeSalary(Title title) {
		this.titles.remove(title);
		title.setEmployee(null);
	}

	public Employee(String firstName, String lastName, @Past Date birthDate, Date hireDate, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((deptEmps == null) ? 0 : deptEmps.hashCode());
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((salaries == null) ? 0 : salaries.hashCode());
		result = prime * result + ((titles == null) ? 0 : titles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (deptEmps == null) {
			if (other.deptEmps != null)
				return false;
		} else if (!deptEmps.equals(other.deptEmps))
			return false;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (salaries == null) {
			if (other.salaries != null)
				return false;
		} else if (!salaries.equals(other.salaries))
			return false;
		if (titles == null) {
			if (other.titles != null)
				return false;
		} else if (!titles.equals(other.titles))
			return false;
		return true;
	}

}
