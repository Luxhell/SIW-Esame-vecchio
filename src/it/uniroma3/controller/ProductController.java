package it.uniroma3.controller;

import it.uniroma3.controller.action.*;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String nextPage = "/invalid.jsp"; 
		ActionCreateProduct azione = new ActionCreateProduct();
		String esito = azione.execute(request);
		
		if(esito.equals("ok")){
			nextPage = "/product.jsp";
		}
		if(esito.equals("ko")){ //se non sono riuscito a fare l'operazione sulla facade
			nextPage = "/error.jsp";
		}
		if(esito.equals("datiNonValidi")){
			nextPage = "/newProduct.jsp";
		}
		
		nextPage = response.encodeURL(nextPage);
		ServletContext application  = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		return; 
	}


}
