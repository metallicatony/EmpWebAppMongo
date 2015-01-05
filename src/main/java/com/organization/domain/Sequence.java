package com.organization.domain;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sequence")
public class Sequence {
	
	@Id
	private String _id;

	private Long empId;

	public String get_id() {
		return _id;
	}
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Sequence [_id=" + _id + ", empId=" + empId + "]";
	}
	
}
