package com.organization.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.adapter.EmployeeAdapter;
import com.organization.bo.EmployeeBO;
import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    private static Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    
    @Autowired
    private EmployeeBO employeeBO;
    
    @Autowired
    private EmployeeAdapter employeeAdapter;
    
    
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
		EmployeeResponse employeeResponse = null;
		log.info("received create employee request employeeRequest={}", employeeRequest);
		try {
			employeeResponse = employeeBO.createEmployee(employeeRequest);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		log.info("returning getAllEmployees response employeeResponse={}", employeeResponse);
		return employeeResponse;
	}
	
	public EmployeeResponses getAllEmployees(String lname) {
		EmployeeResponses employeeResponses = null;
		log.info("received getAllEmployees request");
		try {
			employeeResponses = employeeBO.getAllEmployees(lname);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		log.info("returning getAllEmployees response employeeResponses={}", employeeResponses);
		return employeeResponses;
	}

	public EmployeeResponse getEmployee(String empId) {
		EmployeeResponse employeeResponse = null;
		log.info("received getEmployee request empId={}", empId);
		try {
			employeeResponse = employeeBO.getEmployeeById(empId);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		log.info("returning getEmployee response employeeResponse={}", employeeResponse);
		return employeeResponse;
	}
	
	public EmployeeResponse updateEmployee(String empId, EmployeeRequest employeeRequest) {
		EmployeeResponse employeeResponse = null;
		log.info("received post Employee request empId={} employeeRequest={}", empId, employeeRequest);
		try {
			employeeResponse = employeeBO.updateEmployee(new Long(empId), employeeRequest);
		} catch (Exception e) {
			log.error("received exception", e);
		}
		log.info("returning getEmployee response employeeResponse={}", employeeResponse);
		return employeeResponse;
	}

	@DELETE
	@Path("/{empid}")
	public EmployeeResponse deleteEmployee(@PathParam("empid") String empId) {
		EmployeeResponse employeeResponse = null;
		log.info("received delete employee empId={}", empId);
		try {
			employeeResponse = employeeBO.deleteEmployee(new Long(empId));
		} catch (Exception e) {
			log.error("received exception", e);
		}
		log.info("returning deleteEmployee response employeeResponse={}", employeeResponse);
		return employeeResponse;
	}
	
}
