<%-- 
    Document   : beanJSP
    Created on : 5/11/2019, 01:15:15 PM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP + Java Beans</title>
    </head>
    <body>
        <h1>BeanFecha</h1>
        <!--BeanFecha bfecha = new BeanFecha();-->
        <jsp:useBean id="bfecha" class="beans.BeanFecha" scope="request"/>
        Son las ${bfecha.hora} horas ${bfecha.minutos} minutos
        del día ${bfecha.fecha}
        
        <jsp:useBean id="bfecha2" class="beans.BeanFecha" scope="request">
            <!-- aquí se va a inicializar el atributo formato -->
            <jsp:setProperty name="bfecha" property="formato" value="12"/>
        </jsp:useBean>
        
        <!-- formas de establecer los valores de las propiedades -->
        <jsp:setProperty name="nombre_bean"
                         property="nombre_propiedad"
                         value="valorConstante_propiedad"/>
        
        <!-- cuando la página JSP recibe un parámetro y se desea asignar a la
        propiedad -->
        <jsp:setProperty name="nombre_bean"
                         property="nombre_propiedad"
                         param="nombre_parametro"/>
        
        <!-- asignar el valor de un parámetro que se llama igual que la
        propiedad -->
        <jsp:setProperty name="nombre_bean"
                         property="nombre_propiedad"/>

        <!-- asignar los valores a todas las propiedades cuando tienen el mismo
        nombre las propiedades y los parámetros -->
        <jsp:setProperty name="nombre_bean"
                         property="*"/>
        
        <jsp:setProperty name="nombre_bean"
                         property="expresion"/>
        
        <!-- asignar el valor de la expresión al atributo -->
        <jsp:setProperty name="nombre_bean"
                         property="nombre_propiedad">
            <jsp:attribute name="value">
                expresion
            </jsp:attribute>
        </jsp:setProperty>
            
    </body>
</html>
