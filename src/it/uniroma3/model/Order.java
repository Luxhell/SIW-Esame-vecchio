package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Orders")
@NamedQuery(name = "findOrder", query = "SELECT o FROM Orders o WHERE o.customer.id = :id")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataAperturaOrdine;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataChiusuraOrdine;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataEvasioneOrdine;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="CUSTOMER_ID")
	private Customer cliente;
	
	@OneToMany(mappedBy="ordine", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	private List<OrderLine> lineeDiOrdine;
	
	public Order(){
		
	}

	public Order(Date creationTime, Date closeTime, Date evasionTime, Customer customer) {
		this.dataAperturaOrdine = creationTime;
		this.dataChiusuraOrdine = closeTime;
		this.dataEvasioneOrdine = evasionTime;
		this.cliente = customer;
		this.lineeDiOrdine = new ArrayList<OrderLine>();
	}

	public boolean addLineaDiOrdine(OrderLine or){
		return this.lineeDiOrdine.add(or);
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getDataAperturaOrdine() {
		return dataAperturaOrdine;
	}

	public void setDataAperturaOrdine(java.util.Date creationTime) {
		this.dataAperturaOrdine = creationTime;
	}
	

	public java.util.Date getDataChiusuraOrdine() {
		return dataChiusuraOrdine;
	}

	public void setDataChiusuraOrdine(java.util.Date dataChiusuraOrdine) {
		this.dataChiusuraOrdine = dataChiusuraOrdine;
	}

	public java.util.Date getDataEvasioneOrdine() {
		return dataEvasioneOrdine;
	}

	public void setDataEvasioneOrdine(java.util.Date dataEvasioneOrdine) {
		this.dataEvasioneOrdine = dataEvasioneOrdine;
	}

	public Customer getCliente() {
		return cliente;
	}

	public void setCliente(Customer customer) {
		this.cliente = customer;
	}

	public List<OrderLine> getLineeDiOrdine() {
		return lineeDiOrdine;
	}

	public void setLineeDiOrdine(List<OrderLine> orderLines) {
		this.lineeDiOrdine = orderLines;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
