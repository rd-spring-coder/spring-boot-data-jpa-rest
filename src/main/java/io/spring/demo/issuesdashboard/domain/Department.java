package io.spring.demo.issuesdashboard.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@TableGenerator(allocationSize=1000, name="deptNoGen", pkColumnName = "deptNo")
@Table(name="departments")
public class Department {

	@Id
	@GeneratedValue(generator = "deptNoGen")
	@Column(name="dept_no",columnDefinition = "CHAR(4)")
	private Long deptNo;
	
	@Column(length=40)
	private String deptName;
	
	@JsonBackReference
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity=DeptEmp.class)
	private Set<DeptEmp> deptEmps = new HashSet<>();
	
	@JsonBackReference
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity=DeptManager.class)
	private Set<DeptManager> deptManagers = new HashSet<>();
	
	public Set<DeptEmp> getDeptEmps() {
		return deptEmps;
	}

	public void setDeptEmps(Set<DeptEmp> deptEmps) {
		this.deptEmps = deptEmps;
	}

	public Set<DeptManager> getDeptManagers() {
		return deptManagers;
	}

	public void setDeptManagers(Set<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public Department(){}
	
	public Department(String deptName){
		this.deptName = deptName;
	}

	public Long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptNo=" + deptNo + ", deptName=" + deptName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptName == null) ? 0 : deptName.hashCode());
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode());
		result = prime * result + ((deptEmps == null) ? 0 : deptEmps.hashCode());
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
		Department other = (Department) obj;
		if (deptName == null) {
			if (other.deptName != null)
				return false;
		} else if (!deptName.equals(other.deptName))
			return false;
		if (deptNo == null) {
			if (other.deptNo != null)
				return false;
		} else if (!deptNo.equals(other.deptNo))
			return false;
		if (deptEmps == null) {
			if (other.deptEmps != null)
				return false;
		} else if (!deptEmps.equals(other.deptEmps))
			return false;
		return true;
	}
	
	
}
