/**
* TODO
* @Project: interframe-web-admin
* @Title: CxfServer.java
* @Package com.interframe.hr.ws
* @author jason
* @Date 2016年9月22日 上午9:42:51
* @Copyright
* @Version 
*/
package com.interframe.hr.ws;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
* TODO
* @ClassName: CxfServer
* @author jason
*/
public class CxfServer {

	/**
	* TODO
	* @Title: main
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloWS.class);
        //服务发布的地址
        factory.setAddress("http://localhost:8899/services/hello");
        factory.setServiceBean(new HelloWSImpl());
        factory.create();
	}

}
