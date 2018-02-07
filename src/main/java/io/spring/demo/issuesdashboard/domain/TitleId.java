package io.spring.demo.issuesdashboard.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TitleId implements Serializable {

	private static final long serialVersionUID = 6697992894128228088L;

	private Integer empNo;
	
	private String title;
	
	@Temporal(TemporalType.DATE)
	private Date fromDate;

	public TitleId(){}
	
	public TitleId(String title, Date fromDate){
		this.title = title;
		this.fromDate = fromDate;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
