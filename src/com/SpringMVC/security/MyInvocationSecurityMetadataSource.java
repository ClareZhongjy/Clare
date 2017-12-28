package com.SpringMVC.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{

	private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	private static Map<String,Collection<ConfigAttribute>> resourceMap = null;
	public MyInvocationSecurityMetadataSource(){
		loadResourceDefine();
	}
	//tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系  
	private void loadResourceDefine() {
		resourceMap = new HashMap<String,Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = new SecurityConfig("ROLE_USER");
		atts.add(ca);
		resourceMap.put("/index.jsp", atts);    
		Collection<ConfigAttribute> attsno =new ArrayList<ConfigAttribute>();  
        ConfigAttribute cano = new SecurityConfig("ROLE_NO");  
        attsno.add(cano);  
        resourceMap.put("/other.jsp", attsno);  
	}
	//参数是要访问的url，返回这个url对于的所有权限（或角色）  
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation)object).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while(ite.hasNext()){
			String resURL = ite.next();
			if(urlMatcher.pathMatchesUrl(resURL, url)){
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
