package app.employee.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.Converter;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import app.employee.model.dto.EmployeeDto;
import app.employee.model.entity.Employee;

public final class MapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public MapperUtil() {
	}
	
	public static EmployeeDto convertEmployee(Employee employee) {
		
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
	
	public static EmployeeDto convertEmployeeWithExpressionMap(Employee employee) {
		ExpressionMap<Employee, EmployeeDto> exprMap = 
			m-> m.map(src->src.getFirstName(),
					EmployeeDto::setName);			

		EmployeeDto employeeDto = ConverterUtil.convertCustom(employee, EmployeeDto.class,
				new ExpressionMap[] {exprMap});
		
		return employeeDto;
	}
	
	public static EmployeeDto convertEmployeeWithTypeMap(Employee employee) {
		TypeMap<Employee, EmployeeDto> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeDto.class)
				.addMapping(Employee::getFirstName, EmployeeDto::setName);		

		
		EmployeeDto employeeDto = typeMap.map(employee);
		return employeeDto;
	}
	
	public static EmployeeDto convertEmployeeToEmployeeDto(Employee employee) {
		Converter<String, String> toUpperCase = 
				ctx -> ctx.getSource() == null ? null : ctx.getSource().toUpperCase();
		ExpressionMap<Employee, EmployeeDto> exprMap = 
				m -> m.using(toUpperCase).map(src -> src.getFirstName(), EmployeeDto::setName);

		ExpressionMap<Employee, EmployeeDto> skipping = 
				m -> m.skip(EmployeeDto::setSalary);
		return ConverterUtil.convertCustom(employee, EmployeeDto.class, exprMap);
	}
	
	public static Set<EmployeeDto> convertEmployeeSetToEmployeeDtoSet(Iterable<Employee> employeeSet) {
		Set<EmployeeDto> resultSet = new HashSet<>();
		for (Employee employee : employeeSet) {
			EmployeeDto employeeDto = convertEmployee(employee);
			resultSet.add(employeeDto);
		}
		
		return resultSet;
	}
	
	public static List<EmployeeDto> convertEmployeeListToEmployeeDtoSet(Iterable<Employee> employeeList) {
		List<EmployeeDto> resultList = new ArrayList<>();
		for (Employee employee : employeeList) {
			EmployeeDto employeeDto = convertEmployee(employee);
			resultList.add(employeeDto);
		}
		
		return resultList;
	}
}

