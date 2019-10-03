<%-- 
    Document   : resultado
    Created on : 24 sep 2019, 12:37:24
    Author     : jessicaramsa
--%>

<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="controlador.GenericRepository"%>
<%@page import="controlador.Materias"%>
<%@page import="java.util.Collection"%>
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
            String semestre = (String)request.getParameter("semestre");
            EntityManagerFactory emf;
            EntityManager em;
            emf = Persistence.createEntityManagerFactory("jessicaramsa_EjemploWEBMVC_war_1.0-SNAPSHOTPU");
            em = emf.createEntityManager();
            Collection<Materias> materias = em.createQuery("SELECT e from Materias e WHERE e.semestre = '" + semestre+ "'", Materias.class).getResultList();
            for(Materias m : materias) { 
               out.print("<ul>");
               out.print("<li>" + m.getNombre()+ "</li>");
               out.print("</ul>"); 
            }
            
        %>
    </body>
</html>
