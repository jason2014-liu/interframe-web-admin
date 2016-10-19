/**
* TODO
* @Project: interframe-web-admin
* @Title: UserExcelView.java
* @Package com.interframe.system.web.view
* @author jason
* @Date 2016年10月19日 上午9:44:15
* @Copyright
* @Version 
*/
package com.interframe.system.web.view;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
* TODO
* @ClassName: UserExcelView
* @author jason
*/
@SuppressWarnings("deprecation")
public class UserExcelView extends AbstractExcelView {
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		String fileName = "xx列表.xls";
		response.setContentType("APPLICATION/OCTET-STREAM");
		response.setHeader("Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName, "UTF-8"));
		
	}
	
	

}
