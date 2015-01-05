package com.organization.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.organization.domain.Employee;
import com.organization.domain.Sequence;

@Repository("employeeRepository")
public class EmployeeRepository {
	private static final Logger log = LoggerFactory.getLogger(EmployeeRepository.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * Returns all employees with the given last name
	 * @param lname the last name of the employee
	 * @return a list of employees
	 */
	public List<Employee> findAll(String lname) {
		if (lname == null) {
			return mongoTemplate.findAll(Employee.class);
		} else {
			return mongoTemplate.find(new Query(Criteria.where("lname").is(lname)), Employee.class);
		}
	}
	
	/**
	 * Returns employee with the given employee id
	 * @param empId the id of the employee
	 * @return employee information
	 * @throws Exception
	 */
	public Employee findById(String empId) throws Exception {
		if (empId != null) {
			return mongoTemplate.findOne(new Query(Criteria.where("empId").is(new Long(empId))), Employee.class);
		}
		return null;
	}
	
	/**
	 * Updates the employee with the given information
	 * @param empId the id of the employee
	 * @param updateObject the employee information
	 * @return employee information
	 */
	public Employee updateEmployee(Long empId, Update updateObject) {
		Employee employee = null;
		if (empId != null) {
			employee = mongoTemplate.findAndModify(new Query(Criteria.where("empId").is(empId)), updateObject, Employee.class);
		}
		return employee;
	}
	
	/**
	 * Creates an employee
	 * @param employee information
	 * @return employee information
	 */
	public Employee createEmployee(Employee employee) {
		mongoTemplate.insert(employee);
		log.info("employee={}", employee);
		return employee;
	}
	
	/**
	 * Deletes the employee
	 * @param empId the id of the employee
	 * @return the deleted employee information
	 */
	public Employee deleteEmployee(Long empId) {
		Employee employee = null;
		if (empId != null) {
			employee = mongoTemplate.findAndRemove(new Query(Criteria.where("empId").is(empId)), Employee.class);
		}
		log.info("employee={}", employee);
		return employee;
	}
	
	/**
	 * Gets the next sequence id
	 * @return the sequence id
	 */
	public Long getNextId() {
		// Get object id of the sequence document
		Query queryGet = new Query(Criteria.where("empId").exists(true));
		Sequence sequenceDocGet = mongoTemplate.findOne(queryGet, Sequence.class);
		log.info("objectId={}", sequenceDocGet.get_id());
		
		// Increment emp id of the document fetched above and return the new sequence number
		Sequence sequenceDoc = null;
		Update update = new Update();
		update.inc("empId", 1);
		Query query = new Query(Criteria.where("_id").is(new ObjectId(sequenceDocGet.get_id())));
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		sequenceDoc = mongoTemplate.findAndModify(query, update, options, Sequence.class);
		if (sequenceDoc != null) {
			return sequenceDoc.getEmpId();
		}
		return null;
	}

}
