package com.organization.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.organization.service.request.EmployeeRequest;
import com.organization.service.response.EmployeeResponse;
import com.organization.service.response.EmployeeResponses;

@Produces({ "application/xml", "application/json" })
public interface EmployeeService {

	/**
	 * Returns all employees or all employees that have the given last name if provided
	 * @param lname last name of the employee
	 * @return EmployeeResponses all employees
	 */
	@GET
	@Path("/")
	public EmployeeResponses getAllEmployees(@QueryParam("lname") String lname);
	
	/**
	 * Returns an employee for the given employee id
	 * @param empId the unique id of the employee
	 * @return EmployeeResponse the employee information
	 */
	@GET
	@Path("/{empid}")
	public EmployeeResponse getEmployee(@PathParam("empid") String empId);
	
	/**
	 * Creates a new employee and returns the employee information
	 * @param EmployeeRequest the employee information that needs to be persisted
	 * @return EmployeeResponse the newly created employee information
	 */
	@POST
	@Path("/")
	public EmployeeResponse createEmployee(EmployeeRequest employeeRequest);
	
	/**
	 * Updates and returns the employee details for a given employee id
	 * @param empId the unique id of the employee
	 * @param EmployeeRequest the employee information that needs to be persisted
	 * @return EmployeeResponse the updated employee information 
	 */
	@PUT
	@Path("/{empid}")
	public EmployeeResponse updateEmployee(@PathParam("empid") String empId, EmployeeRequest employeeRequest);
	
	/**
	 * Deletes an employee and returns the employee information
	 * @param empId the unique id of the employee
	 * @return the information of the deleted employee
	 */
	@DELETE
	@Path("/{empid}")
	public EmployeeResponse deleteEmployee(@PathParam("empid") String empId);
}