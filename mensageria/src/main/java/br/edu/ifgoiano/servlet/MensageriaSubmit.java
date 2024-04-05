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

@WebServlet("/teste")
public class MensageriaSubmit extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("emails");
		String titulo = req.getParameter("titulo");
		String cumprimento = req.getParameter("cumprimento");
		LocalDateTime hora = LocalDateTime.now();
		String texto = req.getParameter("texto");
		String emailAutomatico = req.getParameter("emailAutomatico"); 
		String mensagem = "Email enviado para: " + email + "\n" + titulo;
		
		List<String> listaEmails = new ArrayList<String>();
		listaEmails.add("fernandochbrettas@gmail.com");
		listaEmails.add("fernando.brettas@ifgoiano.edu.br");
		listaEmails.add("teste@gmail.com");
		req.setAttribute("listaEmails", listaEmails);
		
		if (email != null && titulo != null && !titulo.isBlank() && texto != null && !texto.isBlank()) {
			if (cumprimento != null) {
				if (cumprimento.equals("formal")) {
					mensagem += "\nPrezada(o),";
				}else if(cumprimento.equals("horario")){
					mensagem += (hora.getHour() >= 5 && hora.getHour() <= 11) ? "\nBom dia,":
								(hora.getHour() >= 12 && hora.getHour() <= 18) ? "\nBoa tarde,": 
								"/Boa noite";
				}
			}
			
			mensagem += "\n" + texto;
			
			if (emailAutomatico.equals("emailAutomatico")) {
				mensagem += "\nAtenção: esse é um e-mail automático e não deve ser respondido.";
			}
			
			System.out.println(mensagem);
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		}else {
			System.out.println("nao ta preenchido");
			
			req.setAttribute("titulo", titulo);
			req.setAttribute("texto", texto);
			req.setAttribute("preenchido", true);
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	
}
