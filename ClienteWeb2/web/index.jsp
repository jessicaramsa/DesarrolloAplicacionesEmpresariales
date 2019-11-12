<%-- 
    Document   : index
    Created on : 12/11/2019, 01:07:23 AM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversión grads C <--> F</title>
    </head>
    <body>
        <div align="center">
            <hr>
            <form style="font-family: arial" action="ServletClienteWebConvT" method="post">
                Grados:<br>
                <input type="text" name="ctGrados" value="${requestScope.result}"
                       style="text-align: right"><br><br>
                <input type="submit" value="Convertir" name="btConvertir">
                <br><br>
                <input type="radio" name="bgGrados" value="aFahr" checked>
                Centígrados a Fahrenheit<br>
                <input type="radio" name="bgGrados" value="aCent">
                Fahrenheit a Centígrados<br>
            </form>
            <hr>
        </div>
    </body>
</html>
