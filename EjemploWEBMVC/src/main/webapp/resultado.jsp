<%-- 
    Document   : resultado
    Created on : 24 sep 2019, 12:37:24
    Author     : jessicaramsa
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materias del semestre</title>
    </head>
    <body>
        <h1 align="center">Materias del semestre seleccionado</h1>
        <%
            List materias =(List)request.getAttribute("resultado");
            Iterator it = materias.iterator();
            while(it.hasNext()) {
                out.print("<br>" + it.next());
            }
        %>
    </body>
</html>
