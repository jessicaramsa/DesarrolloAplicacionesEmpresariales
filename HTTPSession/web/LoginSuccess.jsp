<%-- 
    Document   : LoginSuccess
    Created on : 10/10/2019, 01:35:03 PM
    Author     : jessi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página inicio de sesión</title>
    </head>
    <body>
        <%
            String user = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.html");
            } else {
                user = (String) session.getAttribute("user");
            }
            
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("user"))
                        userName = cookie.getValue();
                    if (cookie.getName().equals("JSESSIONID"))
                        sessionID = cookie.getValue();
                }
            }
        %>
        <h3>Hola <%=userName %>, has iniciado sesión correctamente</h3>
        <h3>El ID de la sesión es = <%=sessionID %></h3>
        <br>
        Usuario = <%=user %>
        <br><br>
        <a href="Checkout.jsp">Revisar tu página web</a>
        <form action="LogoutServlet" method="post">
            <input type="submit" value="Cerrar sesión">
        </form>
    </body>
</html>
