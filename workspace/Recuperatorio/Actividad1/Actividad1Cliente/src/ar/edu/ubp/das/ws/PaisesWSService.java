package ar.edu.ubp.das.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-11-19T19:41:43.536-03:00
 * Generated source version: 3.2.0
 * 
 */
@WebServiceClient(name = "PaisesWSService", 
                  wsdlLocation = "http://localhost:9090/PaisesWSPort?wsdl",
                  targetNamespace = "http://ws.das.ubp.edu.ar/") 
public class PaisesWSService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.das.ubp.edu.ar/", "PaisesWSService");
    public final static QName PaisesWSPort = new QName("http://ws.das.ubp.edu.ar/", "PaisesWSPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9090/PaisesWSPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PaisesWSService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9090/PaisesWSPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PaisesWSService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PaisesWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PaisesWSService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public PaisesWSService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public PaisesWSService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public PaisesWSService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns PaisesWS
     */
    @WebEndpoint(name = "PaisesWSPort")
    public PaisesWS getPaisesWSPort() {
        return super.getPort(PaisesWSPort, PaisesWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PaisesWS
     */
    @WebEndpoint(name = "PaisesWSPort")
    public PaisesWS getPaisesWSPort(WebServiceFeature... features) {
        return super.getPort(PaisesWSPort, PaisesWS.class, features);
    }

}