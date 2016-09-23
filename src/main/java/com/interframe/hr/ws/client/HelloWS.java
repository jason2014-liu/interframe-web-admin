package com.interframe.hr.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-09-22T15:35:53.103+08:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://www.lmstudio.com/hr/services/hello", name = "HelloWS")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWS {

    @WebMethod
    @RequestWrapper(localName = "welcome", targetNamespace = "http://www.lmstudio.com/hr/services/hello", className = "com.interframe.hr.ws.client.Welcome")
    @ResponseWrapper(localName = "welcomeResponse", targetNamespace = "http://www.lmstudio.com/hr/services/hello", className = "com.interframe.hr.ws.client.WelcomeResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String welcome(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );
}