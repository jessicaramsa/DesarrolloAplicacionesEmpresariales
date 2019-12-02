/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jawxs;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author jessicaramsa
 */
@Path("servicio")
public class SWConvertirTemps {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SWConvertirTemps
     */
    public SWConvertirTemps() {
    }

    /**
     * Retrieves representation of an instance of jawxs.SWConvertirTemps
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@QueryParam("bgGrados") String convertir,
        @QueryParam("ctGrados") String sctGrados) {
        Double objGrados = null;
        if (sctGrados != null && !sctGrados.isEmpty()) {
            double nGrados = 0.0;
            try {
                nGrados = Double.parseDouble(sctGrados);
                if (convertir.compareTo("aFahr") == 0)
                    nGrados = 9.0 / 5.0 * nGrados + 32.0;
                if (convertir.compareTo("aCent") == 0)
                    nGrados = (nGrados - 32.0) * 5.0 / 9.0;
                objGrados = nGrados;
            } catch(NumberFormatException ex) {
                System.out.println("Dato grados incorrecto.\n" + ex);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return objGrados.toString();
    }

    /**
     * PUT method for updating or creating an instance of SWConvertirTemps
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
