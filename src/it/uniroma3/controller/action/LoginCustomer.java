package it.uniroma3.controller.action;

import it.uniroma3.controller.helper.HelperLogin;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;

import javax.servlet.http.HttpServletRequest;

public class LoginCustomer implements Action {

	@Override
	public String perform(HttpServletRequest request) {
		
		HelperLogin helper = new HelperLogin();
		
		if (helper.isValid(request)) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			CustomerFacade facade = new CustomerFacade();
			Customer cliente = facade.getCustomer(email, password);
			
			
			
			request.setAttribute("product", product);
			
			return "/product.jsp";
		} else
			return "/invalid.jsp";
	}

}
