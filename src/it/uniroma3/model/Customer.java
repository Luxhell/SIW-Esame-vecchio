package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),

	@NamedQuery(name = "Customer.findOne", query = "SELECT c FROM Customer c WHERE c.email = :email AND c.password = :password"),
})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=50, nullable = false)
	private String nome;

	@Column(length=50, nullable = false)
	private String cognome;

	@Column(length=100, nullable = false)
	private String email;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date dataNascita;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private java.util.Date dataRegistrazione;
	
	@Column(nullable = false)
	private Boolean isAdmin;

	@OneToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ADDRESS_ID")
	private Address indirizzo;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy="cliente", cascade = {CascadeType.ALL})
	private List<Order> ordini;

	public Customer(){
		this.isAdmin = false;
	}

	public Customer(String firstName, String lastName, String email, Date dateOfBirth, Date registrationDate, Address address, String pwd) {
		this.nome = firstName;
		this.cognome = lastName;
		this.email = email;
		this.dataNascita = dateOfBirth;
		this.dataRegistrazione = registrationDate;
		this.indirizzo = address;
		this.password = pwd;
		this.isAdmin = false;		
		this.ordini = new ArrayList<Order>();

	}
	
	public Order getOrdineParticolare(Long id){
			for(Order o: this.ordini){
				if(o.getId().equals(id))
					return o;
			}
		return null;		
	}
	
	public boolean addOrdine(Order order){
		return this.ordini.add(order);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String firstName) {
		this.nome = firstName;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String lastName) {
		this.cognome = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(java.util.Date dateOfBirth) {
		this.dataNascita = dateOfBirth;
	}

	public java.util.Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(java.util.Date registrationDate) {
		this.dataRegistrazione = registrationDate;
	}

	public Address getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Address address) {
		this.indirizzo = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Order> orders) {
		this.ordini = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", Nome=" + nome
				+ ", Cognome=" + cognome + ", Email=" + email
				+ ", Data di nascita="+ dataNascita + ", Data registrazione=" + dataRegistrazione
				+ ", Indirizzo=" + indirizzo + ", " + ", Password=" + password + ", orders=" + ordini + "]";
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	

}
