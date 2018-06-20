package app.employee.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.employee.dao.EmployeeDao;
import app.employee.model.entity.Employee;
import app.employee.service.api.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void registerEmployee(Employee employee) {
		this.employeeDao.save(employee);
	}
	
	
}
