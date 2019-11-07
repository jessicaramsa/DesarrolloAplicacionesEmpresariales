<%-- 
    Document   : formulariosel
    Created on : 7/11/2019, 01:05:18 PM
    Author     : jessicaramsa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario con listas</title>
    </head>
    <body>
        <form method="post" action="listas.jsp">
            Seleccione la fecha:
            <select name="dia">
                <c:forEach begin="1" end="31" var="dia">
                    <option>${dia}</option>
                </c:forEach>
            </select>
            <select name="mes">
                <option value="ene">Enero</option>
                <option value="feb">Febrero</option>
                <option value="mar">Marzo</option>
                <option value="abr">Abril</option>
                <option value="may">Mayo</option>
                <option value="jun">Junio</option>
                <option value="jul">Julio</option>
                <option value="ago">Agosto</option>
                <option value="sep">Septiembre</option>
                <option value="oct">Octubre</option>
                <option value="nov">Noviembre</option>
                <option value="dic">Diciembre</option>
            </select>
            <select name="anio">
                <c:forEach begin="1994" end="2020" var="anio">
                    <option>${anio}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
