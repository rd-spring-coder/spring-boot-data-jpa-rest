package io.spring.demo.issuesdashboard.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="salaries")
public class Salary {
	
	@EmbeddedId
	private SalaryId salaryId;

	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("empNo")
	@JoinColumn(name = "empNo", referencedColumnName = "emp_no")
	@JsonManagedReference
	private Employee employee;

	private Integer salary;
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public SalaryId getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(SalaryId salaryId) {
		this.salaryId = salaryId;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Salary(Date fromDate, Date toDate, Integer salary){
		this.salaryId = new SalaryId();
		this.salaryId.setFromDate(fromDate);
		this.toDate = toDate;
		this.salary = salary;
	}
	
	public Salary(){}
}
