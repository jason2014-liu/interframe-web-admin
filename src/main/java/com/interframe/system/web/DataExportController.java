/**
* TODO
* @Project: interframe-web-admin
* @Title: DataExportController.java
* @Package com.interframe.system.web
* @author jason
* @Date 2016年10月19日 上午9:39:53
* @Copyright
* @Version 
*/
package com.interframe.system.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.interframe.system.web.view.UserExcelView;

/**
* TODO
* @ClassName: DataExportController
* @author jason
*/
@Controller
@RequestMapping("/dataExport")
public class DataExportController {

	@RequestMapping("/exportUser")
	public ModelAndView exportUser(){
		return new ModelAndView(new UserExcelView(),null);
	}
}
