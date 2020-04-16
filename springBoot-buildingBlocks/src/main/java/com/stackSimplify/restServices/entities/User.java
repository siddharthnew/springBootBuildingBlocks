package com.stackSimplify.restServices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//Entity
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
	@NotEmpty(message="Username is Mandatory field.Please provide username")
	private String userName;
	@Size(min=2,message="FirstName should have atleast 2 characters")
	@Column(name = "First_Name", length = 50, nullable = false)
	private String firstname;
	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastname;
	@Column(name = "EMAIL_ID", length = 50, nullable = false)
	private String email;
	@Column(name = "ROLE", length = 50, nullable = false)
	private String role;
	@Column(name = "SSN", length = 50, nullable = false, unique = true)
	private String ssn;
	@OneToMany(mappedBy = "user")
	private List<Order> orders;

	// no -arg constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// field constructor
	public User(Long id, String userName, String firstname, String lastname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	// gettes and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}

}
