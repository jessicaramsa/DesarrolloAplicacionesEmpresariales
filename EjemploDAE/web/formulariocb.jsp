<%-- 
    Document   : formulariocb
    Created on : 7/11/2019, 12:27:25 PM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario casillas de verificación</title>
    </head>
    <body>
        <form action="casilla-ver.jsp" method="post">
            <p>Por favor selecciona los colores que más te gustan:</p>
            <p><input type="checkbox" name="color" value="Rojo">Rojo</p>
            <p><input type="checkbox" name="color" value="Verde">Verde</p>
            <p><input type="checkbox" name="color" value="Azul">Azul</p>
            <p><input type="checkbox" name="color" value="Amarillo">Amarillo</p>
            <p><input type="checkbox" name="color" value="Morado">Morado</p>
            <p><input type="submit" value="Enviar"></p>
        </form>
    </body>
</html>
