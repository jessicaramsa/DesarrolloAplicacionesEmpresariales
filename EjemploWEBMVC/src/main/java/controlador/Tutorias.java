/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "Tutorias",
//        urlPatterns = {"/Tutorias"},
//        initParams = { @WebInitParam(name = "RutaCarpeta", value = "C:/Temp/dap")}
//)
public class Tutorias extends HttpServlet {
    String carpeta = null;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        carpeta = getInitParameter("RutaCarpeta");
        if (carpeta == null) {
            System.err.println("No se especificó la carpeta de destino");
        }
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                // C:\Temp\glassfish5\glassfish\domains\domain1\config
                FileWriter fw = new FileWriter(carpeta + "/tutorias.txt", true);
                PrintWriter fichTutorias = new PrintWriter(fw);

                /* Tomar los datos recibidos del cliente y escribirlos
                   en el archivo. Se finaliza cada registro con la marca
                   <FIN> para su posterior identificación */
                Enumeration nombresParams = request.getParameterNames();
                while (nombresParams.hasMoreElements()) {
                    String param = (String) nombresParams.nextElement();
                    String valor = request.getParameter(param);
                    fichTutorias.println(param + ": " + valor);
                }
                
                /* Mediante el siguiente código se obtienen los checkbox
                   que se tengan seleccionados en la página web de la que se
                   recibe la petición
                   Este código no funcionaría hasta que se tengan agregados los
                   controles correspondientes en la página HTML */
                String[] valoresTransportes = request.getParameterValues("transporte");
                for (int i = 0; i < valoresTransportes.length; i++) {
                    fichTutorias.println(valoresTransportes[i]);
                }

                fichTutorias.println("<FIN>");

                // Cerrar el archivo
                fichTutorias.close();
                fw.close();

                // Responder al cliente
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Respuesta a la solicitud</title>");
                out.println("</head>");
                out.println("Su petición ha sido registrada exitosamente");
                out.println("</html>");
            } catch (IOException e) {
                out.println("Hubo un problema registrando su solicitud.");
                out.println("<br>Por favor, inténtelo otra vez");
            }
            
            // Cerrar el flujo
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
