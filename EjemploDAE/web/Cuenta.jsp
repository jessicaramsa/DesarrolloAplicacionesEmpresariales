<%-- 
    Document   : Cuenta
    Created on : 29/10/2019, 12:59:43 PM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página JSP Cuenta</title>
    </head>
    <body>
        <!-- Incrementar el contador para esta página. El valor es guardado
        en la variable "atrCuenta" definida en el ámbito de aplicación -->
        <c:set var="atrCuenta" scope="application" value="${atrCuenta + 1}"/>
        <h1>Demostración de seguimiento a nivel de aplicación</h1>
        <!-- Visualizar la cuenta para esta página -->
        ${param.parNombre}, has visitado esta página
        ${atrCuenta} ${(atrCuenta > 1) ? " veces." : " vez."}
    </body>
</html>
