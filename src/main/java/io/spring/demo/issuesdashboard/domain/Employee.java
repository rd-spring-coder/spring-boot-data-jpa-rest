package io.spring.demo.issuesdashboard.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
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

	@JsonIgnore
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

}
