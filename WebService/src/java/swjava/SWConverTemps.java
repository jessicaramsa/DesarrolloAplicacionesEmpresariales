package swjava;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author jessicaramsa
 */
@WebService
public class SWConverTemps {
    // Convertir grados F a C
    @WebMethod(operationName = "ConvFahrACent")
    public double ConvFahrACent(double gFahr) {
        return ((gFahr - 32.0) * 5.0) / 9.0;
    }
    
    // Convertir grados C a F
    @WebMethod(operationName = "ConvCentAFahr")
    public double ConvCentAFahr(double gCent) {
        return 9.0 / 5.0 * gCent + 32.0;
    }
}
