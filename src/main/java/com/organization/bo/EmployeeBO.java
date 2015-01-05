package com.organization.bo;

import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

public interface EmployeeBO {
	public EmployeeResponses getAllEmployees(String lname);
	public EmployeeResponse getEmployeeById(String empId) throws Exception;
	public EmployeeResponse updateEmployee(Long empId, EmployeeRequest employeeRequest) throws Exception;
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) throws Exception;
	public EmployeeResponse deleteEmployee(Long empId) throws Exception;
}
