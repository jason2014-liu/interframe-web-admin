/**
* TODO
* @Project: interframe-web-admin
* @Title: HelloWSImpl.java
* @Package com.interframe.hr.ws
* @author jason
* @Date 2016年9月22日 上午9:38:50
* @Copyright
* @Version 
*/
package com.interframe.hr.ws;

import javax.jws.WebService;

/**
* TODO
* @ClassName: HelloWSImpl
* @author jason
*/
@WebService(
        endpointInterface = "com.interframe.hr.ws.HelloWS",
        portName = "HelloWSPort",
        serviceName = "HelloWSService",
        targetNamespace = "http://www.lmstudio.com/hr/services/hello"
    )
public class HelloWSImpl implements HelloWS {
	
	@Override
    public String welcome(String name) {
        return "Welcome " + name;
    }

}