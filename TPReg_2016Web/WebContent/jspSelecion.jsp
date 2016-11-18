<%@page import="entities.Personaje"%>
<%@page import="logic.Controlador"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleccion</title>
</head>
<body>
<form action="servletSeleccion" method="POST">
<h4>SELECCIONE LOS JUGADORES</h4>	
	<div class="sidebar-module">
            
              <%Controlador ctrl = new Controlador();
              ArrayList<Personaje> list = ctrl.getAll(); %>  
			
   
			<h4>Personaje 1<select name="listado_1" id="l1">
			<option value=""> 
			<% 
  				for(Personaje i : list) 
				{ 
       				String nombre = i.getNombre();
       				%> 
    					<option value="<%=nombre%>"><%=nombre%></option> 
					<%  
    			}
			%>
  			</select></h4>
  			
  			<h4>Personaje 2<select name="listado_2" id="l1">
  			<option value=""> 
			<% 
  				for(Personaje i : list) 
				{ 
       				String nombre = i.getNombre();
       				%> 
    					<option value="<%=nombre%>"><%=nombre%></option> 
					<%  
    			}
			%>
  			</select></h4>  
            <button type="submit">A Jugar !</button>  
</div>
</form>
</body>
</html>