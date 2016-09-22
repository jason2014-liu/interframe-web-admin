/**
* TODO
* @Project: interframe-web-admin
* @Title: AuthValidateInterceptor.java
* @Package com.interframe.hr.ws
* @author jason
* @Date 2016年9月22日 下午2:56:34
* @Copyright
* @Version 
*/
package com.interframe.hr.ws;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * TODO 服务端输入拦截器 拦截请求有没有授权信息
 * 
 * <!-- 认证信息格式如下 --> <auth xmlns="http://www.tmp.com/auth"> <name>admin</name>
 * <password>admin</password> </auth>
 * 
 * @ClassName: AuthValidateInterceptor
 * @author jason
 */
public class AuthValidateInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public AuthValidateInterceptor() {

		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		List<Header> headers = message.getHeaders();
		if (headers == null || headers.size() < 1) {
			throw new Fault(new Exception("无授权信息！"));
		}

		Element auth = null;
		// 获取授权信息元素
		for (Header header : headers) {
			QName qname = header.getName();
			String ns = qname.getNamespaceURI();
			String tagName = qname.getLocalPart();
			if (ns != null && ns.equals("http://www.tmp.com/auth") && tagName != null && tagName.equals("auth")) {
				auth = (Element) header.getObject();
				break;
			}
		}

		// 如果授权信息元素不存在，提示错误
		if (auth == null) {
			throw new Fault(new Exception("无授权信息！"));
		}

		NodeList nameList = auth.getElementsByTagName("name");
		NodeList pwdList = auth.getElementsByTagName("password");
		if (nameList.getLength() != 1 || pwdList.getLength() != 1) {
			throw new Fault(new Exception("授权信息错误！"));
		}

		String name = nameList.item(0).getTextContent();
		String password = pwdList.item(0).getTextContent();
		if (!"admin".equals(name) || !"admin".equals(password)) {
			throw new Fault(new Exception("授权信息错误！"));
		}
	}

}
