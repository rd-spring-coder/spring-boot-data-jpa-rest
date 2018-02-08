package io.spring.demo.issuesdashboard.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_emp")
public class DeptEmp extends DeptEmpType {

	public DeptEmp(){}
	public DeptEmp(Employee e, Department d, Date fromDate, Date toDate){
		super(e,d,fromDate,toDate);
	}
}
