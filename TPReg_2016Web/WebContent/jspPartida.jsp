<%@page import="entities.Personaje"%>
<%@page import="logic.ControladorPartida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Partida</title>
</head>
<body>
<form action="servletPartida" method="POST">
	<% 
	Personaje p1=(Personaje)session.getAttribute("personaje_1");
	Personaje p2=(Personaje)session.getAttribute("personaje_2");
	ControladorPartida ctrl = (ControladorPartida)session.getAttribute("controladorPartida");
	String turno = (String)session.getAttribute("turno");
	
	String vida_1 = Integer.toString(ctrl.getJugador_1().getVidaRestante());
	String energia_1 = Integer.toString(ctrl.getJugador_1().getEnergiaRestante());
	String defensa_1 = Integer.toString(ctrl.getJugador_1().getDefensa());
	String nombre_1 = p1.getNombre();
	
	String vida_2 = Integer.toString(ctrl.getJugador_2().getVidaRestante());
	String energia_2 = Integer.toString(ctrl.getJugador_2().getEnergiaRestante());
	String defensa_2 = Integer.toString(ctrl.getJugador_2().getDefensa());
	String nombre_2 = p2.getNombre();
	
	
	%>
	<h4><%=nombre_1 %> <%=nombre_2 %></h4>
	<div>Vida <input  name="vida_1" type= "text" DISABLED value="<%=vida_1%> "> Vida <input  name="vida_2" type= "text" DISABLED value="<%=vida_2%>"></div>
	<div>Energía<input  name="energia_1" type= "text" DISABLED value="<%=energia_1%> ">Energía<input  name="energia_2" DISABLED type= "text" value="<%=energia_2%>"></div>
	<div>Defensa<input  name="defensa_1" type= "text" DISABLED value="<%=defensa_1%> "> Defensa<input  name="defensa_2" DISABLED type= "text" value="<%=defensa_2%>"></div>
	<div></div>
	<div>Es el turno de: <%=turno %></div>

	<div></div>
	<div>	
	<input  name="ataque" type= "text" value="">
	<button type="submit"  value="Atacar"  name="btnAtaca">Atacar</button> 
	<button type="submit" value="Defender" name="btnDefiende">Defender</button>
	
	
	
	</div>
</form>
</body>
</html>