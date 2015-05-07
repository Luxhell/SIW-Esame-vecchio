package it.uniroma3.controller.helper;

import javax.servlet.http.HttpServletRequest;

public class HelperLogin {

	public boolean isValid(HttpServletRequest request) {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean errors = false;

		if ( email == null || email.equals("")) {
			request.setAttribute("emailErr","Email è obbligatorio");
			errors = true;
		}

		if ( password == null || password.equals("")) {
			request.setAttribute("passwordErr","Password è obbligatorio");
			errors = true;
		}
		return !errors;
	}
}
