package org.java.code_first_exercise.billing_system_db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billing_detail")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicBillingDetail {

	private String number;
	private User owner;
	
	public BasicBillingDetail() {
	}
	
	@Id
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@ManyToOne(targetEntity = User.class)
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	
}
