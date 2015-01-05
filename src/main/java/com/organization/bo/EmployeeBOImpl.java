package com.organization.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.organization.adapter.EmployeeAdapter;
import com.organization.domain.Employee;
import com.organization.repository.EmployeeRepository;
import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

@Component("employeeBO")
public class EmployeeBOImpl implements EmployeeBO {
	private static final Logger log = LoggerFactory.getLogger(EmployeeBOImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeAdapter employeeAdapter;
	
	public EmployeeResponses getAllEmployees(String lname) {
		List<Employee> empDomainList = employeeRepository.findAll(lname);
		EmployeeResponses empResponseList = null;
		if (empDomainList != null && empDomainList.size() > 0) {
			empResponseList = employeeAdapter.convertToEmployeeResponse(empDomainList);
		}
		log.info("employeeResponseList={}", empResponseList);
		return empResponseList;
	}

	public EmployeeResponse getEmployeeById(String empId) throws Exception {
		EmployeeResponse employeeResponse = null;
		Employee employee = employeeRepository.findById(empId);
		if (employee != null) {
			employeeResponse = employeeAdapter.convertToEmployeeResponse(employee);
		}
		log.info("employeeResponse={}", employeeResponse);
		return employeeResponse;
	}

	public EmployeeResponse updateEmployee(Long empId, EmployeeRequest employeeRequest) throws Exception {
		EmployeeResponse employeeResponse = null;
		Update updateObject = null;
		if (employeeRequest != null) {
			updateObject = employeeAdapter.buildDocument(employeeRequest);
		}

		Employee employee = employeeRepository.updateEmployee(empId, updateObject);
		if (employee != null && employee.getEmpId() != null) {
			employeeResponse = getEmployeeById(employee.getEmpId().toString());
		}
		return employeeResponse;
	}
	
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) throws Exception {
		EmployeeResponse employeeResponse = null;
		Employee employee = null;
		
		// convert employeeRequest to mongo update object
		if (employeeRequest != null) {
			Long empId = employeeRepository.getNextId();
			log.info("new employeeId={}", empId);
			employee = employeeAdapter.buildDocument(empId, employeeRequest);
		}
		
		employeeRepository.createEmployee(employee);
		
		if (employee.get_id() != null) {
			employeeResponse = employeeAdapter.convertToEmployeeResponse(employee);
		}
		
		log.info("employeeResponse={}", employeeResponse);
		return employeeResponse;
	}

	public EmployeeResponse deleteEmployee(Long empId) throws Exception {
		EmployeeResponse employeeResponse = null;
		Employee employee = employeeRepository.deleteEmployee(empId);
		
		if (employee != null) {
			employeeResponse = employeeAdapter.convertToEmployeeResponse(employee);
		}
		log.info("employeeResponse={}", employeeResponse);
		return employeeResponse;
	}

}
