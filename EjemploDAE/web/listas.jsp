<%-- 
    Document   : listas
    Created on : 7/11/2019, 01:14:12 PM
    Author     : jessi
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario con listas</title>
    </head>
    <body>
        <c:catch var="errorOcurrido">
            <fmt:parseDate parseLocale="es_ES" var="fecha"
                           value="${param.dia}-${param.mes}-${param.anio}"/>
            <fmt:formatDate value="${fecha}" dateStyle="full"/>
        </c:catch>
        <c:if test="${not empty errorOcurrido}">
            Error: el parámetro día, supuestamente no es correcto.
        </c:if>
    </body>
</html>
