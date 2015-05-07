package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperProduct;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class CreateProduct implements Action {

	//ecco il metodo perform della Action
	public String perform(HttpServletRequest request) {
		
		//invoca un helper
		//anche l'Helper potrebbe essere un'interfaccia come la Action poichè fa solamente validità di dati
		HelperProduct helper = new HelperProduct();
		
		//l'helper controlla la validità dei dati
		if (helper.isValid(request)) {
			String name = request.getParameter("name");
			String code = request.getParameter("code");
			Float price = Float.parseFloat(request.getParameter("price"));
			String description = request.getParameter("description");
			
			//invoca il metodo della Facade
			ProductFacade facade = new ProductFacade();
			Product product = facade.createProduct(name, code, price, description);
			request.setAttribute("product", product);
			
			return "/product.jsp";
		} else{
			//se l'helper non va a buon fine si ritorna alla form iniziale
			return "/newProduct.jsp";
		}
	}
}
