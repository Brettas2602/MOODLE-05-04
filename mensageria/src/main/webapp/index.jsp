<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="teste" method="post" id="mensageria">
		
		<h2>Mensageria</h2>
		
		<label for="cars">Emails:</label> 
		<select name="emails" id="emails" form="mensageria">
			<c:forEach items="${listaEmails}" var="email">
				<option value="${email}">${email}</option>
			</c:forEach>
		</select> <br>
		
		<input type="radio" id="formal" name="cumprimento" value="formal">
		<label for="formal">Cumprimento formal</label>
		<input type="radio" id="horario" name="cumprimento" value="horario"> 
		<label for="horario">Cumprimento conforme horário</label><br>
		
		<input type="checkbox" id="emailAutomatico" name="emailAutomatico" value="emailAutomatico">
		<label for="emailAutomatico"> Incluir aviso de "E-mail automático"</label><br>
		
		<label for="titulo">Título:</label>
		<input type="text" id="titulo" name="titulo" size="54" value="${titulo}"> <br>
		
		<label for="texto">Texto:</label> <br>
		<textarea id="texto" name="texto" rows="5" cols="60">${texto}</textarea> <br>
		
		<input type="submit" value="Enviar">
	</form>
	
	<c:if test="${preenchido}">
		<p>nao foi prennchido</p>
	</c:if>
</body>
</html>