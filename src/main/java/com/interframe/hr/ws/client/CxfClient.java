/**
* TODO
* @Project: interframe-web-admin
* @Title: CxfClient.java
* @Package com.interframe.hr.ws.client
* @author jason
* @Date 2016年9月22日 下午3:41:25
* @Copyright
* @Version 
*/
package com.interframe.hr.ws.client;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * TODO
 * 
 * @ClassName: CxfClient
 * @author jason
 */
public class CxfClient {

	/**
	 * TODO
	 * 
	 * @Title: main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cxfInvoke();
	}

	public static void jaxwsInvoke() {
		// jaxws调用
		// URL不是必须的，除非服务的地址有改变
		URL wsdlUrl = null;
		try {
			wsdlUrl = new URL("http://localhost:8888/interframe-web-admin/services/Hello?wsdl");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HelloWSService helloWSS = new HelloWSService(wsdlUrl);
		HelloWS helloWS = helloWSS.getHelloWSPort();
		String welcome = helloWS.welcome("jason");
		System.out.println(welcome);
	}

	public static void cxfInvoke() {

		/*
		 * cxf调用 首先在客户端添加cxf <dependency> <groupId>org.apache.cxf</groupId>
		 * <artifactId>cxf-rt-frontend-jaxws</artifactId>
		 * <version>3.1.1</version> </dependency> <dependency>
		 * <groupId>org.apache.cxf</groupId>
		 * <artifactId>cxf-rt-transports-http</artifactId>
		 * <version>3.1.1</version> </dependency>
		 */
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(HelloWS.class);
		factory.setAddress("http://localhost:8888/interframe-web-admin/services/Hello");

		factory.getInInterceptors().add(new org.apache.cxf.interceptor.LoggingInInterceptor());

		// 客户端授权拦截器
		factory.getOutInterceptors().add(new com.interframe.hr.ws.client.AuthAddInterceptor());
		factory.getOutInterceptors().add(new org.apache.cxf.interceptor.LoggingOutInterceptor());

		HelloWS helloWS = factory.create(HelloWS.class);
		String welcome = helloWS.welcome("jason");
		System.out.println(welcome);
	}

}
