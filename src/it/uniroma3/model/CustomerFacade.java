package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

public class CustomerFacade {
	
	private EntityManager em;
	
	public CustomerFacade(EntityManager em) {
		this.em = em;
	}

	public void createCustomer(String firstName, String lastName, String email, Date dateOfBirth, Date registrationDate,
			String street, String city, String state,
			String zipcode, String country){
		
	Customer c = new Customer();
	c.setDataRegistrazione(new Date());
	c.setNome(firstName);
	c.setCognome(lastName);
	c.setEmail(email);
	c.setDataNascita(dateOfBirth);
	c.setDataRegistrazione(registrationDate);
	c.setIsAdmin(false);
	Address a = new Address();
	a.setCitta(city);
	a.setStato(state);
	a.setRegione(country);
	a.setVia(street);
	a.setCap(zipcode);
	c.setIndirizzo(a);
	
	this.em.persist(c);
	}
	

	public List<Customer> getRubrica(){
		String sql = "SELECT c FROM Customer c";		
		return this.em.createQuery(sql, Customer.class).getResultList();
	}
	
	public List<Order> getOrders (Long id){
		return this.em.createQuery("findOrder", Order.class).setParameter("id", id).getResultList();
	}
	
	
}
