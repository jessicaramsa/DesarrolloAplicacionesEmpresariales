<%-- 
    Document   : ambito
    Created on : 31/10/2019, 12:41:11 PM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Incrementar el contador para esta pagina. El valor es guardado en
        el objeto implícito application con el nombre 2atrCuenta.-->
        <%
            Integer cuenta = (Integer)application.getAttribute("atrCuenta");
            String s = " vez.";
            if (cuenta == null) {
                cuenta = new Integer(1);
            } else {
                cuenta = new Integer(cuenta.intValue() + 1);
                s = " veces.";
            }
            application.setAttribute("atrCuenta", cuenta);
            
            /*Object getAttribute(String nombreAtributo)
            Object getAttribute(String nombreAtributo, int ambito)
            void setAttribute(String nombreAtributo, Object valorAtributo)
            void setAttribute(String nombreAtributo, Object valorAtributo, int ambito)

            PageContext.APPLICATION_SCOPE
            PageContext.REQUEST_SCOPE
            PageContext.SESSION_SCOPE
            PageContext.PAGE_SCOPE
            */
        %>
        <h1>Demostración de seguimiento a nivel de aplicación</h1>
        <!-- Visualizar la cuenta para esta página -->
        <p>Has visitado esta página <%=cuenta%><%=s%></p>
        <br>
        <p><%= request.getParameter("parNombre")%>, has visitado esta página
        <%= application.getAttribute("atrCuenta")%> veces</p>
        <br>
        <p>${param.parNombre}, has visitado esta página ${atrCuenta} veces</p>
    </body>
</html>
