package com.organization.service.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employeeResponses")
@XmlType(name = "", propOrder = {"employeeResponse"})
public class EmployeeResponses extends Error {
	
	@XmlElement(name = "employeeResponse", required = true)
	private List<EmployeeResponse> employeeResponse;

	public List<EmployeeResponse> getEmployeeResponses() {
		return employeeResponse;
	}

	public void setEmployeeResponses(List<EmployeeResponse> employeeResponses) {
		this.employeeResponse = employeeResponses;
	}

	@Override
	public String toString() {
		return "EmployeeResponses [employeeResponse=" + employeeResponse
				+ "]";
	}
	
}
