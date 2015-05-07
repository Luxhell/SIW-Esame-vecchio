package it.uniroma3.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerFacade {
	
	private EntityManager em;
	private Map<Long, Customer> customers;
	
	public CustomerFacade(){
		this.customers = new HashMap<>();
	}
	
	public CustomerFacade(EntityManager em) {
		this.em = em;
	}

	public void createCustomer(String firstName, String lastName, String email, Date dateOfBirth, Date registrationDate,
			String street, String city, String state, String zipcode, String country, String pwd){
		
	Customer c = new Customer();
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
	
	this.em.persist(c);
	}
	

	public List<Customer> getAllCustomer(){
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);
		List<Customer> results = query.getResultList();
		return results;
	}
	
	public Customer getCustomer(String email, String password){
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findOne", Customer.class);
		Customer results = query.getSingleResult();
		return results;
	}
	
//	public List<Order> getOrders (Long id){
//		return this.em.createQuery("findOrder", Order.class).setParameter("id", id).getResultList();
//	}
	
	
}
