package com.organization.service.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@XmlType(name = "", propOrder = {"firstName","lastName", "salary", "deptName"})
public class EmployeeRequest {
	
	@XmlElement(name = "firstName", required = true)
	private String firstName;
	
	@XmlElement(name = "lastName", required = true)
	private String lastName;
	
	@XmlElement(name = "salary", required = true)
	private Double salary;
	
	@XmlElement(name = "deptName", required = true)
	private String deptName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [firstName=" + firstName + ", lastName="
				+ lastName + ", salary=" + salary + ", deptname=" + deptName
				+ "]";
	}

}
