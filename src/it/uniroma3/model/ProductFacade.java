package it.uniroma3.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductFacade {

	private Map<Long, Product> prodotti;

	public ProductFacade() {
		this.prodotti = new HashMap<>();
	}

	public Product inserisciProdotto(String nome, String codice, String descrizione, Float prezzo, Float qty) {
		Product p = new Product(nome, codice, descrizione, prezzo, qty);
		this.prodotti.put(p.getId(), p);
		return p;
		//IL FORNITORE NON ME LO CAGO PIU'?????
	}

	public Map<Long, Product> tuttiProdotti() {
		return this.prodotti;
	}

	public Product getProduct(Long id) {
		return prodotti.get(id);
	}

	public List<Product> getAllProducts() {
		return new LinkedList<Product>(prodotti.values());
	}

	public void updateProduct(Product product) {
		prodotti.put(product.getId(), product);
	}

	public void deleteProduct(Long id) {
		prodotti.remove(id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((prodotti == null) ? 0 : prodotti.hashCode());
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
		ProductFacade other = (ProductFacade) obj;
		if (prodotti == null) {
			if (other.prodotti != null)
				return false;
		} else if (!prodotti.equals(other.prodotti))
			return false;
		return true;
	}	
}
