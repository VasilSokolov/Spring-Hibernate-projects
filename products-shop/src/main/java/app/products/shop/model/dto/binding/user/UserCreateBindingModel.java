package app.products.shop.model.dto.binding.user;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserCreateBindingModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name = "first-name")
	private String firstName;
	@XmlAttribute(name = "last-name")
	private String lastName;
	@XmlAttribute(name = "age")
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
