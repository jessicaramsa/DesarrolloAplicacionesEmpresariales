/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author jessicaramsa
 */
@WebService(serviceName = "SWConverTemps")
public class SWConverTemps {
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    // Convertir grados F a C
    @WebMethod(operationName = "ConvFahrACent")
    public double ConvFahrACent(double gFahr) {
        return ((gFahr - 32.0) * 5.0) / 9.0;
    }
    
    // Convertir grados C a F
    @WebMethod(operationName = "ConvCentAFahr")
    public double ConvCEntAFahr(double gCent) {
        return 9.0 / 5.0 * gCent + 32.0;
    }
}
