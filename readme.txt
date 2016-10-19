连接池：https://github.com/alibaba/druid
监控：
https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatFilter
还可以按需要配置Spring和Web的关联监控。


mybatis doc:
http://www.mybatis.org/mybatis-3/zh/getting-started.html
http://www.mybatis.org/spring/zh/index.html

code generator: http://www.mybatis.org/generator/running/runningWithEclipse.html


cxf(http://cxf.apache.org/docs/cxf-architecture.html)

JAX-WS

Data Bindings:

Data bindings implement the mapping between XML elements and Java objects.
Currently supported data bindings include JAXB 2.x (default), Aegis, Apache XMLBeans, 
Service Data Objects (SDO) and JiBX (under development).

Protocol Bindings

Bindings provide ways to map concrete formats and protocols on top of transports.
CXF currently supported the following bindings protocols: SOAP 1.1, SOAP 1.2, REST/HTTP, pure XML and CORBA.
The prototypical binding is SOAP. It has its own Message class called the SoapMessage. 
It adds the ability to hold the current SoapVersion and the headers for the message.


Transports(http://cxf.apache.org/docs/transports.html)

CXF includes its own transport abstraction layer to hide transport specific details from the binding and front end layers. 
Currently supported transports include: HTTP, HTTPs, HTTP-Jetty, HTTP-OSGI, Servlet, local, JMS, In-VM 
and many others via the Camel transport for CXF such as SMTP/POP3, TCP and Jabber.

CXF includes two HTTP options for building services. There is a Servlet transport for those who are deploying into a Servlet container. 
There is also a standalone HTTP server based on Jetty.

客户端
用wsimport或者wsdl2java把服务端发布的服务生成Java对象。 
wsimport是jdk提供的wsdl转java对象工具，在jdk的bin目录下可以找到。用法是
"D:\Program Files\Java\jdk1.8.0_25\bin\wsimport.exe" -encoding utf-8 -d D:\dev\wsdl\cxfserver\wsimport\compile 
-s D:\dev\wsdl\cxfserver\wsimport\src -p com.rvho.cxfclient.wsdl.wsimport.hello http://localhost:8999/services/hello?wsdl


wsdl2java是cxf提供的wsdl转java对象工具，在cxf的bin目录下可以找到。用法是
"D:\dev\library\java\cxf\apache-cxf-3.1.0\bin\wsdl2java" -p com.rvho.cxfclient.wsdl.cxf.hello -d D:\dev\wsdl\cxfserver\cxf\src http://localhost:8999/services/hello?wsdl

Using Log4j Instead of java.util.logging
CXF uses the java.util.logging package ("Java SE Logging") by default. But it is possible to switch CXF to instead use Log4J.

Add the file META-INF/cxf/org.apache.cxf.Logger to the classpath and make sure it contains the following content:
org.apache.cxf.common.logging.Log4jLogger

可查看发布的soap services和restful services
http://localhost:8888/interframe-web-admin/services/  

JAX-RS


权限管理：
user role permission

用户管理

角色管理

 
