package br.edu.ifgoiano.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class MensageriaInicio extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> listaEmails = new ArrayList<String>();
		listaEmails.add("fernandochbrettas@gmail.com");
		listaEmails.add("fernando.brettas@ifgoiano.edu.br");
		listaEmails.add("teste@gmail.com");
		
		req.setAttribute("listaEmails", listaEmails);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
