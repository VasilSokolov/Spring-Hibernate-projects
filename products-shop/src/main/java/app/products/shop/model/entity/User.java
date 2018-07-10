package app.products.shop.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Set<User> friends;
	private Set<Product> productsForBuying;
	private Set<Product> productsForSelling;
			
	public User() {
		this.friends = new HashSet<>();
		this.productsForBuying = new HashSet<>();
		this.productsForSelling = new HashSet<>();
	}

	public User(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false)
	@Size(min = 3)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	@Column(nullable = false)
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}		

	@ManyToMany
	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	@OneToMany(mappedBy = "buyer")
	public Set<Product> getProductsForBuying() {
		return productsForBuying;
	}

	public void setProductsForBuying(Set<Product> productsForBuying) {
		this.productsForBuying = productsForBuying;
	}

	@OneToMany(mappedBy = "seller")
	public Set<Product> getProductsForSelling() {
		return productsForSelling;
	}

	public void setProductsForSelling(Set<Product> productsForSelling) {
		this.productsForSelling = productsForSelling;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
