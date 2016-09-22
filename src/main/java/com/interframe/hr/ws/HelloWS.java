/**
* TODO
* @Project: interframe-web-admin
* @Title: HelloWS.java
* @Package com.interframe.hr.ws
* @author jason
* @Date 2016年9月22日 上午9:36:57
* @Copyright
* @Version 
*/
package com.interframe.hr.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
* TODO
* @ClassName: HelloWS
* @author jason
*/
@WebService(
        name = "HelloWS",
        targetNamespace = "http://www.lmstudio.com/hr/services/hello"
    )
public interface HelloWS {
    @WebMethod
    String welcome(@WebParam(name = "name") String name);
}
