package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=100, nullable = false)
	private String email;

	
	@Column(nullable = false)
	private Boolean isAdmin;
	
	@Column(nullable = false)
	private String password;


	public Admin(){
		this.isAdmin = true;
	}

	
	public Admin(Long id, String email, String pwd) {
		this.id = id;
		this.email = email;
		this.password = pwd;
		this.isAdmin = true;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + "]";
	}
	
	

}

