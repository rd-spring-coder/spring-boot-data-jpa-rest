package io.spring.demo.issuesdashboard.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Dept_Emp_Type")*/
@MappedSuperclass
public abstract class DeptEmpType {

	@EmbeddedId
	private DeptEmpId id;
	
	@Temporal(TemporalType.DATE)
	private Date fromDate;
	
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("empNo")
	@JoinColumn(name="empNo",referencedColumnName="emp_no")
	@JsonManagedReference
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("deptNo")
	@JoinColumn(name="deptNo",referencedColumnName="dept_no")
	@JsonManagedReference
	private Department department;
	
	public DeptEmpType(){
		
	}
	
	public DeptEmpType(Employee employee, Department department, Date fromDate, Date toDate){
		this.id = new DeptEmpId(employee.getEmpNo(), department.getDeptNo());
		this.employee = employee;
		this.department = department;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public DeptEmpId getId() {
		return id;
	}

	public void setId(DeptEmpId id) {
		this.id = id;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DeptEmp [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", employee=" + employee
				+ ", department=" + department + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
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
		DeptEmpType other = (DeptEmpType) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}
	
	
}
