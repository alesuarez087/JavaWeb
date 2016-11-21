<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ganador</title>
</head>
<body>
<form action="servletPartida" method="POST">
<% 
	String turno = (String)session.getAttribute("ganador");
%>


<h4>El ganador de la partida es: <%=turno%></h4>

</form>
<div>
<form action="servletSeleccion" method="post">
	<button type="submit"  value="Inicio"  name="btnInicio">Iniciar nueva partida</button>

</form>
</div>
</body>
</html>