<%-- 
    Document   : index
    Created on : 11/11/2019, 10:56:18 AM
    Author     : jessicaramsa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conversión grados C <--> F</title>
    </head>
    <body>
        <div align="center">
            <!-- Invocar al servicio web -->
            <%
                String sctGrados = request.getParameter("ctGrados");
                if (sctGrados != null && !sctGrados.isEmpty()) {
                    double nGrados = 0.0;
                    jaxws.SWConverTemps_Service service;
                    jaxws.SWConverTemps port;
                    
                    try {
                        // Crear un objeto de la clase que implementa el servicio
                        service = new jaxws.SWConverTemps_Service();
                        port = service.getSWConverTempsPort();
                        // Obtener el valor numérico escrito en la caja de texto
                        nGrados = Double.parseDouble(sctGrados);
                        // Realizar la conversión invocando al método correspondiente
                        // del objeto port de tipo SWConverTemps
                        String convertir = request.getParameter("bgGrados");
                        if (convertir.compareTo("aFahr") == 0) {
                            nGrados = port.convCentAFahr(nGrados);
                        }
                        if (convertir.compareTo("aCent") == 0) {
                            nGrados = port.convFahrACent(nGrados);
                        }
                        // Mostrar el resultado en la caja de texto
                        Double objGrados = nGrados;
                        session.setAttribute("result", objGrados);
                    } catch(NumberFormatException ex) {
                        // Se envia al log del servidor
                        System.out.println("Dato grados incorrecto\n");
                    } catch(Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            %>
            <hr>
            <form style="font-family: arial">
                Grados:<br>
                <input type="text" name="ctGrados" value="${result}"
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
