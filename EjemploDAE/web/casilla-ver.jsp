<%-- 
    Document   : casilla-ver
    Created on : 7/11/2019, 12:40:14 PM
    Author     : jessicaramsa
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario con listas</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty paramValues.color}">
                Tus colores favoritos son:
                <ul>
                    <c:forEach var="item" items="${paramValues.color}">
                        <li>${item}</li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                ¿No te gusta ninguno de esos colores?
            </c:otherwise>
        </c:choose>
    </body>
</html>
