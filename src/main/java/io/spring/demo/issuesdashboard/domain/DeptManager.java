package io.spring.demo.issuesdashboard.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_manager")
public class DeptManager extends DeptEmpType{
	public DeptManager(){}
	public DeptManager(Employee e, Department d, Date fromDate, Date toDate){
		super(e,d,fromDate,toDate);
	}
}
