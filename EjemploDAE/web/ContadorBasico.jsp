<%-- 
    Document   : ContadorBasico
    Created on : 15/10/2019, 01:00:18 PM
    Author     : jessicaramsa
--%>
<%@page import="Clases.Contador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include %>
<%@taglib uri="https:/java.sun.com/istl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!  int count = 0;%>
        <h1>El contador es:</h1>
        <%= ++ count %>
    </body>
</html>
