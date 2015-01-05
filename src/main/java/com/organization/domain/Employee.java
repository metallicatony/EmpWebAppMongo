package com.organization.domain;

import java.io.Serializable;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = -4435384885078147241L;

	@Id
	private String _id;
	private Long empId;
	private String fname;
	private String lname;
	private String deptName;
	private Double salary;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", empId=" + empId + ", fname=" + fname
				+ ", lname=" + lname + ", deptName=" + deptName + ", salary="
				+ salary + "]";
	}

}
