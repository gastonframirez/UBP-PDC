
package ar.edu.ubp.das.fds.cxf;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.1.7
 * 2017-11-27T18:20:22.248-03:00
 * Generated source version: 3.1.7
 */

@WebFault(name = "Exception", targetNamespace = "http://cxf.fds.das.ubp.edu.ar/")
public class Exception_Exception extends java.lang.Exception {
    
    private ar.edu.ubp.das.fds.cxf.Exception exception;

    public Exception_Exception() {
        super();
    }
    
    public Exception_Exception(String message) {
        super(message);
    }
    
    public Exception_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public Exception_Exception(String message, ar.edu.ubp.das.fds.cxf.Exception exception) {
        super(message);
        this.exception = exception;
    }

    public Exception_Exception(String message, ar.edu.ubp.das.fds.cxf.Exception exception, Throwable cause) {
        super(message, cause);
        this.exception = exception;
    }

    public ar.edu.ubp.das.fds.cxf.Exception getFaultInfo() {
        return this.exception;
    }
}