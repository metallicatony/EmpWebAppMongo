package com.organization.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.organization.domain.Employee;
import com.organization.repository.EmployeeRepository;
import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

@Component("employeeAdapter")
public class EmployeeAdapterImpl implements EmployeeAdapter {
    private static Logger log = LoggerFactory.getLogger(EmployeeAdapterImpl.class);

	public EmployeeResponses convertToEmployeeResponse(List<Employee> employeeList) {
		List<EmployeeResponse> employeeResponseList = null;
		EmployeeResponses employeeResponses = null;
		if (employeeList != null && employeeList.size() > 0) {
			employeeResponseList = new ArrayList<EmployeeResponse>();
			employeeResponses = new EmployeeResponses();
			for (Employee employee: employeeList) {
				EmployeeResponse employeeResponse = convert(employee);
				employeeResponseList.add(employeeResponse);
			}
			employeeResponses.setEmployeeResponses(employeeResponseList);
		}
		return employeeResponses;
	}

	public EmployeeResponse convertToEmployeeResponse(Employee employee) {
		return convert(employee);
	}
	
	private EmployeeResponse convert(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployeeId(employee.getEmpId());
		employeeResponse.setFirstName(employee.getFname());
		employeeResponse.setLastName(employee.getLname());
		employeeResponse.setDeptName(employee.getDeptName());
		employeeResponse.setSalary(employee.getSalary());
		return employeeResponse;
	}

	public Update buildDocument(EmployeeRequest employeeRequest) {
		Update updateObject = new Update();

		if (employeeRequest.getFirstName() != null) {
			updateObject.set("fname", employeeRequest.getFirstName());
		}
		if (employeeRequest.getLastName() != null) {
			updateObject.set("lname", employeeRequest.getLastName());
		}
		if (employeeRequest.getSalary() != null) {
			updateObject.set("salary", employeeRequest.getSalary());
		}
		if (employeeRequest.getDeptName() != null) {
			updateObject.set("deptName", employeeRequest.getDeptName());
		}
		return updateObject;
	}
	
	public Employee buildDocument(Long empId, EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		
		if (empId != null) {
			employee.setEmpId(empId);
		}
		
		if (employeeRequest.getFirstName() != null) {
			employee.setFname(employeeRequest.getFirstName());
		}
		if (employeeRequest.getLastName() != null) {
			employee.setLname(employeeRequest.getLastName());
		}
		if (employeeRequest.getSalary() != null) {
			employee.setSalary(employeeRequest.getSalary());
		}
		if (employeeRequest.getDeptName() != null) {
			employee.setDeptName(employeeRequest.getDeptName());
		}
		return employee;
	}


}
