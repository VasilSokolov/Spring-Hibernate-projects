package app.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.employee.model.entity.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
