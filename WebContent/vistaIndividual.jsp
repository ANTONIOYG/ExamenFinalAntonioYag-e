<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.examen.modelo.Tarjeta"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Individual</title>
<style>
table, td, th {
    border: 1px solid blue;
}

table {
    width: 100%;
}

th {
    height:50px;
}
</style>

</head>
<body>
<form action="darAlta" method="get">
 <% Tarjeta tarjeta = (Tarjeta)request.getAttribute("tarjeta"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Numero</th>
      <th>CupoMaximo</th>
      <th>CupoDisponible</th>
      <th>Tipo</th>
      <th>NumeroComprobacion</th>
      <th>Contrasehna</th> 
    </tr>
   <tr>
      <td><input type="text" name="id" value="<%=tarjeta.getId() %>" readonly="readonly"/></td>  
      <td><input type="text" name="numero" value="<%=tarjeta.getNumero() %>"/></td>
      <td><input type="text" name="cupoMaximo" value="<%=tarjeta.getCupoMaximo() %>"/></td>
      <td><input type="text" name="cupoDisponible" value="<%=tarjeta.getCupoDisponible() %>"/></td>
      <td><input type="text" name="tipo" value="<%=tarjeta.getTipo() %>"/></td>
      <td><input type="text" name="numeroComprobacion" value="<%=tarjeta.getNumeroComprobacion() %>"/></td>
      <td><input type="text" name="contrasehna" value="<%=tarjeta.getContrasehna() %>"/></td>
  </tr>
</table>
 <input class="botones" type="submit" value="Actualizar" id="actualizar" name="actualizar"/>
</form>

 
  <a href="index.html">Ir a inicio</a>
</body>
</html>
      

        