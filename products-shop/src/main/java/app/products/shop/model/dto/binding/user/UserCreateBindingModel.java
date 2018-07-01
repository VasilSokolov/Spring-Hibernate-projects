package app.products.shop.model.dto.binding.user;

import java.io.Serializable;

public class UserCreateBindingModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String firstName;
	private String lastName;
	private Integer age;
	
	public UserCreateBindingModel() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserCreateBindingModel [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
	
	
}
