package com.SpringMVC.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware{
	// Spring应用环境上下文
	private static ApplicationContext	applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) 
	{
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	/**
	 * 获取实例化对象
	 * 
	 * @param name
	 *        在spring容器注册的bean实例名称
	 * @return
	 * @throws BeansException
	 */
	public static Object getBean(String name) 
	{
		return applicationContext.getBean(name);
	}

	/**
	 * 匹配所给名称的bean定义
	 * 
	 * @param name
	 * @return
	 */
	public static boolean containsBean(String name)
	{
		return applicationContext.containsBean(name);
	}

	/**
	 * @param name
	 * @return Class 注册对象的类
	 * @throws NoSuchBeanDefinitionException
	 */
	public static Class<?> getType(String name)
	{
		return applicationContext.getType(name);
	}

	/**
	 * 
	 * @param name
	 *        Bean名称
	 * @param requiredType
	 * @return
	 * @throws BeansException
	 */
	public static <T> T getBean(String name, Class<T> requiredType)
	{
		return applicationContext.getBean(name, requiredType);
	}
}
