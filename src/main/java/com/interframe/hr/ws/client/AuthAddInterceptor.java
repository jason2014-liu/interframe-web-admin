/**
* TODO
* @Project: interframe-web-admin
* @Title: AuthAddInterceptor.java
* @Package com.interframe.hr.ws.client
* @author jason
* @Date 2016年9月22日 下午2:51:39
* @Copyright
* @Version 
*/
package com.interframe.hr.ws.client;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * TODO 添加授权拦截器 用于在客户端发请求时添加授权
 * 
 * @ClassName: AuthAddInterceptor
 * @author jason
 */
public class AuthAddInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public AuthAddInterceptor() {
		// 准备发送阶段
		super(Phase.PREPARE_SEND);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		List<Header> headers = message.getHeaders();

		Document doc = DOMUtils.createDocument();

		// Element auth = doc.createElement("auth");
		Element auth = doc.createElementNS("http://www.tmp.com/auth", "auth");

		Element name = doc.createElement("name");
		name.setTextContent("admin");

		Element password = doc.createElement("password");
		password.setTextContent("admin");

		auth.appendChild(name);
		auth.appendChild(password);

		headers.add(new Header(new QName(""), auth));
	}

}
