/**
* TODO
* @Project: interframe-web-admin
* @Title: Book.java
* @Package com.interframe.hr.rs
* @author jason
* @Date 2016年9月22日 下午4:28:10
* @Copyright
* @Version 
*/
package com.interframe.hr.rs;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO 书籍实体类
 * 
 * @ClassName: Book
 * @author jason
 */
@XmlRootElement(name = "Book")
public class Book {
	// id
	private String id;

	// 书名
	private String name;
	// 作者
	private String author;
	// 价格
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
