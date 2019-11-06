<%-- 
    Document   : Cuenta
    Created on : 29/10/2019, 12:59:43 PM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <%= request.getParameter("parNombre")%>, has visitado esta página
        <%= application.getAttribute("atrCuenta") %> veces
        <br><br>
        <!-- segunda forma -->
        ${param.parNombre}, has visitado esta página
        ${atrCuenta} ${(atrCuenta > 1) ? " veces." : " vez."}
        <br><br>
        <!-- tercera forma de hacer lo mismo -->
        ${param.parNombre}, has visitado esta página
        <c:set var="str" scope="application" value="vez" />
        <c:if test="${atrCuenta > 1}">
            <c:set var="str" scope="application" value="veces"/>
        </c:if>
        ${atrCuenta} ${str}
        <br><br>
        
        <!-- cuarta forma de hacer lo mismo -->
        ${param.parNombre}, has visitado esta página
        <c:choose>
            <c:when test="atrCuenta == 1">
                <c:set var="str" scope="application" value="vez"/>
            </c:when>
            <c:otherwise>
                <c:set var="str" scope="application" value="veces"/>
            </c:otherwise>
        </c:choose>
        ${atrCuent} ${str}
        <br><br>
        
        <table border="1">
            <c:forEach var="item" items="${pageScope}">
                <tr>
                    <td>${item}</td>
                </tr>
            </c:forEach>
        </table>
        
        <jsp:forward page="pagina.jsp"/>
    </body>
</html>