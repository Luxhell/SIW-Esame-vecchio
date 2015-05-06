package it.uniroma3.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Float prezzoUnitario;
	
	@Column(nullable = false)
	private Integer quantita;
	
	@ManyToOne (cascade = {CascadeType.PERSIST})
	@JoinColumn(name="ORDER_ID")
	private Order ordine;
	
	@OneToOne (cascade = {CascadeType.PERSIST})
	@JoinColumn(name="PRODUCT_ID")
	private Product prodotto;
	
	public OrderLine(){
		
	}

	public OrderLine(Float unitPrice, Integer quantity, Order order,
			Product product) {
		this.prezzoUnitario = unitPrice;
		this.quantita = quantity;
		this.ordine = order;
		this.prodotto = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(Float unitPrice) {
		this.prezzoUnitario = unitPrice;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantity) {
		this.quantita = quantity;
	}

	public Order getOrder() {
		return ordine;
	}

	public void setOrder(Order order) {
		this.ordine = order;
	}

	public Product getProduct() {
		return prodotto;
	}

	public void setProduct(Product product) {
		this.prodotto = product;
	}
	
	

}