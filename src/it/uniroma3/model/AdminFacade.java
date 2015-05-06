package it.uniroma3.model;

import java.util.List;

import javax.persistence.EntityManager;

public class AdminFacade {

private EntityManager em;
	
	public AdminFacade(EntityManager em) {
		this.em = em;
	}

	public void createAdmin(String email, String password){
		
		Admin a = new Admin();
		a.setEmail(email);
		a.setPassword(password);
		this.em.persist(a);
	}
	

	public Admin getAdmin(){
		String sql = "SELECT a FROM Admin a";		
		return this.em.createQuery(sql, Admin.class).getSingleResult();
	}

}

