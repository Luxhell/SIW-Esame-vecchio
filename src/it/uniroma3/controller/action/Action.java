package it.uniroma3.controller.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {
	//questa interfaccia offre il metodo perform
	public String perform(HttpServletRequest request);

}
