<%-- 
    Document   : formulario
    Created on : 5/11/2019, 01:44:24 PM
    Author     : jessicaramsa
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP: formularios</title>
    </head>
    <body>
        <c:if test="${!empty param['nombre']}">
            <jsp:forward page="saludo.jsp" />
        </c:if>
        <h3>Rellenar un formulario</h3>
        <form action="formulario.jsp" method="get">
            Nombre: <input type="text" name="nombre" value="${param['nombre']}">
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
