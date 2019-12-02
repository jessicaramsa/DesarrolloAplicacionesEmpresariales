/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jessicaramsa
 */
@WebServlet(name = "ServletClienteWebConvT", urlPatterns = {"/"})
public class ServletClienteWebConvT extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            double nGrados = 0.0;
            jaxws.SWConverTemps_Service service;
            jaxws.SWConverTemps port;
            
            try {
                String sctGrados = request.getParameter("ctGrados");
                if (sctGrados == null && sctGrados.isEmpty())
                    throw new NumberFormatException();
                
                service = new jaxws.SWConverTemps_Service();
                port = service.getSWConverTempsPort();
                nGrados = Double.parseDouble(sctGrados);
                String convertir = request.getParameter("bgGrados");
                if (convertir.compareTo("aFahr") == 0)
                    nGrados = port.convCentAFahr(nGrados);
                if (convertir.compareTo("aCent") == 0)
                    nGrados = port.convFahrACent(nGrados);
                Double objGrados = nGrados;
                request.setAttribute("result", objGrados);
                mostrarPagina(request, response);
            } catch (NumberFormatException ex) {
                System.out.println("Dato grados incorrecto.\n");
                mostrarPagina(request, response);
            } catch (Exception ex) {
                System.out.println("No se puede acceder al servicio.\n");
                mostrarPagina(request, response);
            }
        }
    }
    
    protected void mostrarPagina(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        if (dispatcher != null)
            dispatcher.forward(request, response);
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
        return "Servlet para acceder al servicio web SWConverTemps";
    }// </editor-fold>
}
