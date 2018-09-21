package app.employee.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private BigDecimal salary;
    private String addressCityName;

    public EmployeeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    @Override
    public String toString() {
        return "EmployeeDto [name=" + name + ", salary=" + salary + ", addressCityName=" + addressCityName + "]";
    }


}
