//aggiunto un commento
package it.uniroma3.model;


import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("siw-esame");
		EntityManager em = emf.createEntityManager();
		Address address1 = new Address("via del cazzo", "Fregene", "Lazio", "00054", "Italia");
		Address address2 = new Address("via del fornitore", "Ladispoli", "Toscana", "00053", "Francia");
		Date date = new Date(946684800000L);
		Date datePiuGrande = new Date();	
			
		Product product1 = new Product();
		product1.setNome("cocaina");
		product1.setCodice("6969");
		product1.setDescrizione("un pizzico di piacere bianco");
		product1.setPrezzo(3.5F);
		product1.setQuantita(5F);
		
		//Il prodotto al momento non conosce il proprio fornitore
		Provider fornitore1 = new Provider("IVA01", "3935000691", "fornitore@gmail.com", address2);
		
		fornitore1.addProdotto(product1);
		
		//il prodotto ora conosce il suo fornitore
		//NON SERVE PERCHE' HO IL MAPPEDBY 
		//product1.addFornitore(fornitore1);
		
		Customer cliente1 = new Customer("nome cliente","cognome cliente", "cliente@gmail.com", date, date, address1, "123456");
		
		//creo il l'ordine1 di cazzo
		Order ordine1 = new Order(date, datePiuGrande, null, cliente1);	
		
		//creo la linea1 del carello1
		OrderLine linea1DiOrdine1 = new OrderLine(product1.getPrezzo(), 1, ordine1, product1);
		
		ordine1.addLineaDiOrdine(linea1DiOrdine1);
		cliente1.addOrdine(ordine1);
		
		//LE SEGUENTI TRE RIGHE SERVONO SOLAMENTE A VEDERE SE VENGONO PERSISTITE LE COLONNE "DataEvasioneOrdine"
		Order temp = cliente1.getOrdineParticolare(ordine1.getId());
		temp.setDataEvasioneOrdine(date);
		cliente1.addOrdine(temp);
		//FINO A QUI

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(fornitore1);
		em.persist(cliente1);
		
		tx.commit();
		em.close();
		emf.close();
	}
}
