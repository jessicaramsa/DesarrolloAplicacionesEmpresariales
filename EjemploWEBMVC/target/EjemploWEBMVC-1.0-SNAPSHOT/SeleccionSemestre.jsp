<%-- 
    Document   : SeleccionSemestre
    Created on : 23/10/2019, 03:25:14 PM
    Author     : Uroboros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guía de materias</title>
    </head>
    <body>
        <h3>Bienvenido ${sessionScope.username}</h3>
        
        <h1 align="center">Guía de materias por semestre</h1>
        <form action="SeleccionSemestre" method="GET">
            <p>Seleccione el semestre</p>
            <select name="semestre" size="1">
                <option value="1">Primero</option>
                <option value="2">Segundo</option>
                <option value="3">Tercero</option>
                <option value="4">Cuarto</option>
                <option value="5">Quinto</option>
                <option value="6">Sexto</option>
                <option value="7">Séptimo</option>
                <option value="8">Octavo</option>
                <option value="9">Noveno</option>
            </select>
            <br><br>
            <center>
                <input type="submit" value="Enviar">
            </center>
        </form>
    </body>
</html>
