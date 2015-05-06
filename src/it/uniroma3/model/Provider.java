package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "findProvider", query = "SELECT p FROM provider p WHERE p.products.id = :id ")
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String partitaIVA;
	
	@Column(length=200, nullable = false)
	private String telefono;
	
	@Column(length=200, nullable = false)
	private String email;
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ADDRESS_ID")
	private Address indirizzo;
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	private List<Product> prodotti;
	
	public Provider(){
		
	}

	public Provider(String iva, String phoneNumber, String email, Address address) {
		this.partitaIVA = iva;
		this.telefono = phoneNumber;
		this.email = email;
		this.indirizzo = address;
		this.prodotti = new ArrayList<Product>();
	}
	
	public boolean addProdotto(Product prodotto){
		return this.prodotti.add(prodotto);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String phoneNumber) {
		this.telefono = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Address address) {
		this.indirizzo = address;
	}

	public List<Product> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Product> products) {
		this.prodotti = products;
	}
	
	
	
	

}
