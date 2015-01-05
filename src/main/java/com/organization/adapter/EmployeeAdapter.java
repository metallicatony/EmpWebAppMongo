package com.organization.adapter;

import java.util.List;

import org.springframework.data.mongodb.core.query.Update;

import com.organization.domain.Employee;
import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

public interface EmployeeAdapter {
	public EmployeeResponses convertToEmployeeResponse(List<Employee> employee);
	public EmployeeResponse convertToEmployeeResponse(Employee employee);
	public Update buildDocument(EmployeeRequest employeeRequest);
	public Employee buildDocument(Long empId, EmployeeRequest employeeRequest);
}
