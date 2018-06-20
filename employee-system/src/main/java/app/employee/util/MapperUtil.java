package app.employee.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import app.employee.model.dto.EmployeeDto;
import app.employee.model.entity.Employee;

public final class MapperUtil {

	public MapperUtil() {
	}
	
	public static EmployeeDto convertEmployee(Employee employee) {
		ModelMapper modelMapper = new ModelMapper();
		
		PropertyMap<Employee, EmployeeDto> employeeDtoMap = new PropertyMap<Employee, EmployeeDto>(){
			protected void configure() {
//				String name = source.getFirstName() + " " + source.getLastName();
			    map().setName(source.getFirstName());
			}
		};
		modelMapper.addMappings(employeeDtoMap);
		
		EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
	}
}
