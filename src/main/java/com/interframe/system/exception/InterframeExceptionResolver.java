/**
* TODO
* @Project: interframe-web-admin
* @Title: InterframeExceptionResolver.java
* @Package com.interframe.system.exception
* @author jason
* @Date 2016年11月2日 下午4:21:06
* @Copyright
* @Version 
*/
package com.interframe.system.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * TODO
 * 
 * @ClassName: InterframeExceptionResolver
 * @author jason
 */
public class InterframeExceptionResolver extends SimpleMappingExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		try {
			if (isAcceptApplicationJson(request)) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				OutputStream out = response.getOutputStream();
				PrintStream ps = new PrintStream(out);
				ps.println(ex.getMessage());
				// ex.printStackTrace(ps);
				ps.flush();
				ps.close();
				return null;
			}
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return super.doResolveException(request, response, handler, ex);
	}

	/**
	 * 判断header当中属性accept是否为json类型
	 * 
	 * @param request
	 * @return true or false
	 */
	private boolean isAcceptApplicationJson(HttpServletRequest request) {
		return request.getHeader("accept").indexOf("application/json") != -1;
	}
}
