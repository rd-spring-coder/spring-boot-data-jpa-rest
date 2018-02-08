package io.spring.demo.issuesdashboard.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DeptEmpId implements Serializable {

	private static final long serialVersionUID = -8592085228601603153L;

	@Column(name="emp_no")
	private Integer empNo;
	
	@Column(name="dept_no")
	private Long deptNo;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}
	
	public DeptEmpId(){}
	
	public DeptEmpId(Integer empNo, Long deptNo){
		this.empNo = empNo;
		this.deptNo = deptNo;
	}
}
