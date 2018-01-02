package com.cmfintech.ds.beans.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.cmfintech.ds.beans.BeanDefinition;

/**
 * @Title: AbstractBeanFactory.java
 * @Description:
 * @Company 招商局金融科技
 * @author 杜松
 * @date 2017年12月20日 下午9:05:08
 * @version V1.0
 */
public abstract class AbstractBeanFactory implements BeanFactory {
	HashMap<String, BeanDefinition> beanDefinitions;
	HashMap<String, Object> ioc;

	public HashMap<String, Object> getIoc() {
		return ioc;
	}


	/**
	 * 
	 * @Description:根据bean名获取Bean
	 * @param name
	 *            查询的bean名称
	 * @return Object bean对象
	 * @author 杜松
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	 * @date 2017年12月20日 下午9:03:52
	 */
	public Object getBean(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		if (!beanDefinitions.containsKey(name)) {
			throw new RuntimeException("你要查找的bean名称：" + name + "不存在，请检查拼写是否正确！");
		}
		Object bean = ioc.get(name);
		//容器中没有bean，则说明是propotype
		if (bean == null) {
			bean = createBean(beanDefinitions.get(name));
		}
		return bean;
	}

	
	/**
	 * 
	 * @Description:创建bean对象 分为单例和原型两种模式，利用java的反射机制，实现实例化，属性注入
	 * @return Object bean对象
	 * @author 杜松
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * @date 2017年12月20日 下午9:13:57
	 */
	abstract Object createBean(BeanDefinition beanDefinition) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;

}
