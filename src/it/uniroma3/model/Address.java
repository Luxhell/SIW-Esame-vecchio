package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, length=500)
	private String via;

	@Column(nullable=false, length=500)
	private String citta;

	@Column(nullable=false, length=500)
	private String stato;

	@Column(nullable=false, length=500)
	private String cap;

	@Column(nullable=false, length=500)
	private String regione;
	
	public Address(){
		
	}

	public Address( String street, String city, String state, String zipcode, String country) {
		this.via = street;
		this.citta = city;
		this.stato = state;
		this.cap = zipcode;
		this.regione = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}
}
