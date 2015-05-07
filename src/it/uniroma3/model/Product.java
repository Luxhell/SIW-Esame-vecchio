package it.uniroma3.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String codice;
	
	@Column
	private String descrizione;
	
	@Column(nullable = false)
	private Float prezzo;
	
	@Column(nullable = false)
	private Float quantita;
	
	@ManyToMany(mappedBy="prodotti", cascade={CascadeType.PERSIST} )
	private List<Provider> fornitori;
	
	public Product() {
	}
	
	public Product(String name, String code, String description, Float price, Float qty) {
		this.nome = name;
		this.prezzo = price;
		this.descrizione = description;
		this.codice = code;
		this.quantita = qty;
		this.fornitori = new LinkedList<Provider>();
	}
	
	public boolean addFornitore(Provider provider){
		return this.fornitori.add(provider);
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Float getQuantita() {
		return quantita;
	}

	public void setQuantita(Float quantita) {
		this.quantita = quantita;
	}

	public boolean equals(Object obj) {
		Product product = (Product)obj;
		return this.getCodice().equals(product.getCodice());
	}
	
	public List<Provider> getFornitori() {
		return fornitori;
	}

	public void setFornitori(List<Provider> fornitori) {
		this.fornitori = fornitori;
	}

	public int hashCode() {
		return this.codice.hashCode();
	}

	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Prodotto"); 
		sb.append("{id=").append(id); 
		sb.append(", nome='").append(nome); 
		sb.append(", prezzo=").append(prezzo); 
		sb.append(", descrizione='").append(descrizione); 
		sb.append(", codice='").append(codice);
		sb.append(", quantità='").append(quantita);
		sb.append("}\n");
		return sb.toString();
	}


}