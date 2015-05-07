package it.uniroma3.controller;

import it.uniroma3.controller.action.Action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		//dal path (ovvero la string http che è arrivata al controller) ci restituisce il nome dell'azione della 
		//classe (Customer Login)
		String actionName = path2action(request);
		Action action;
		try {
			//le cose contenute nel "try" "catch" è molto simile a diadia dell'anno scorso
			//istanzio un oggetto usando la stringa sopra creata
			action = (Action)Class.forName(actionName).newInstance(); //è equivalente a new ProductCreate ma il vantaggio
																	  //è che questo funziona con qualunque comando che 
																	  //gli invio
			//il "perform" equivale all'execute di mvc-es1
			nextPage = action.perform(request);
		} catch (Exception e) {
			nextPage = "/index.jsp";
		} 
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
