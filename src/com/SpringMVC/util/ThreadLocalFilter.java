package com.SpringMVC.util;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.SpringMVC.common.HttpConstants;
import com.SpringMVC.entity.User;
import com.SpringMVC.service.impl.UserService;

public class ThreadLocalFilter implements Filter {
	private static final String reg_filter	= "[\\S]+(.do)[\\s]*";
	private static Logger logger = Logger.getLogger(ThreadLocalFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest httpRequest, ServletResponse httpResponse, FilterChain filter)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) httpRequest;
		HttpServletResponse response = (HttpServletResponse) httpResponse;
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(HttpConstants.SESSION_ATTRIBUTE_USER);
		
		if(user == null ){
			String contextPath = request.getContextPath();
			String requestURI = request.getRequestURI();
			logger.info(contextPath);
			logger.info(requestURI);
			logger.info(Pattern.matches(reg_filter, requestURI));
			if (Pattern.matches(reg_filter, requestURI) && !requestURI.startsWith(contextPath + "/_ajax.do")
					&& !requestURI.startsWith(contextPath + "login/preLogin.do")&& !requestURI.startsWith(contextPath + "/login.do")
					&& !requestURI.startsWith(contextPath + "/loginOut.do"))
			{
				String redirectURI = contextPath + "/login/preLogin.do";
				response.sendRedirect(redirectURI);
				return;
			}
	}else if(user != null){
		
		UserService userService = SpringContextUtil.getBean("userService", UserService.class);
		
		
		User sessionUser = userService.getUserByLogin(user);
		String dataSessionId = sessionUser.getSession();
		String pageSessionId = session.getId();
		
		if(!pageSessionId.equals(dataSessionId)){
			logger.info("session已失效，跳转至登录页面！");
			session.invalidate();
			String redirectURI = request.getContextPath() + "/login/preLogin.do";
			response.sendRedirect(redirectURI);
		}
		
		
	}
		try{
			filter.doFilter(httpRequest, httpResponse);
			}catch(Exception e){
				
			}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
