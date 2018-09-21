package app.employee;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.employee.model.dto.EmployeeDto;
import app.employee.model.entity.Address;
import app.employee.model.entity.City;
import app.employee.model.entity.Employee;
import app.employee.service.api.EmployeeService;
import app.employee.util.MapperUtil;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger log = LogManager.getLogger(Runner.class);
    private EmployeeService employeeService;

    @Autowired
    public Runner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Mock data for employee
    public Employee mockData() throws ParseException {
        String birthday = "12-12-2006";
        Date birthdayDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthday);
        Address address = new Address("street Tintynov", new City("Sofia"));
        Employee employee = new Employee("Pesho", "Petrov", birthdayDate, BigDecimal.valueOf(3000.55), address);

        this.employeeService.registerEmployee(employee);
//		System.out.println(employee);
        log.info(employee);
        return employee;
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = mockData();
//		EmployeeDto test1 = MapperUtil.convertEmployee(employee);
//		EmployeeDto test2 = MapperUtil.convertEmployeeWithExpressionMap(employee);
        EmployeeDto test2 = MapperUtil.convertEmployeeWithTypeMap(employee);

        System.out.println("Employee Dto" + test2);
        log.info("Success END");
    }

}
