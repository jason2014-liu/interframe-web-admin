/**
* TODO
* @Project: interframe-web-admin
* @Title: RestClient.java
* @Package com.interframe.hr.rs
* @author jason
* @Date 2016年9月23日 上午9:42:05
* @Copyright
* @Version 
*/
package com.interframe.hr.rs;

import org.springframework.web.client.RestTemplate;

/**
* TODO
* @ClassName: RestClient
* @author jason
*/
public class RestClient {

	/**
	* TODO
	* @Title: main
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8888/interframe-web-admin/services/library/";
		
		String book = restTemplate.getForObject(url+"books/{id}/", String.class, "blog");
		
		System.out.println("return string:"+book);
	}

}
