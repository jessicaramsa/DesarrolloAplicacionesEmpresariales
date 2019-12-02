/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;

/**
 * Jersey REST client generated for REST resource:we [servicio]<br>
 * USAGE:
 * <pre>
 *        ClienteJava client = new ClienteJava();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author jessicaramsa
 */
public class ClienteJava {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RESTExample/webresources/";

    public ClienteJava() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("servicio");
    }

    /**
     * @param responseType Class representing the response
     * @param bgGrados query parameter
     * @param ctGrados query parameter
     * @return response object (instance of responseType class)
     */
    public String getHtml(String bgGrados, String ctGrados) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (ctGrados != null)
            resource = resource.queryParam("ctGrados", ctGrados);
        if (bgGrados != null)
            resource = resource.queryParam("bgGrados", bgGrados);
        return resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    /**
     * @param requestEntity request data@return response object (instance of responseType class)
     */
    public void putHtml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_HTML));
    }

    private Form getQueryOrFormParams(String[] paramNames, String[] paramValues) {
        Form form = new javax.ws.rs.core.Form();
        for (int i = 0; i < paramNames.length; i++) {
            if (paramValues[i] != null) {
                form = form.param(paramNames[i], paramValues[i]);
            }
        }
        return form;
    }

    public void close() {
        client.close();
    }
    
}
