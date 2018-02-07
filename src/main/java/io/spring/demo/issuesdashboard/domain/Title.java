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
@Table(name="titles")
public class Title {
	
	@EmbeddedId
	private TitleId titleId;
	
	@Temporal(TemporalType.DATE)
	private Date toDate;
	
	public Title(){}
	
	public Title(String title, Date fromDate, Date toDate){
		this.titleId = new TitleId(title, fromDate);
		this.toDate = toDate;
	}
	
	@MapsId("empNo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="empNo",referencedColumnName="emp_no")
	@JsonManagedReference
	private Employee employee;
	
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

	public TitleId getTitleId() {
		return titleId;
	}

	public void setTitleId(TitleId titleId) {
		this.titleId = titleId;
	}
	

}
