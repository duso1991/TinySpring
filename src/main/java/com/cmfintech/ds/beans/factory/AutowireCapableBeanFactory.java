package com.cmfintech.ds.beans.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;

import com.cmfintech.ds.beans.BeanDefinition;
import com.cmfintech.ds.beans.Property;
import com.cmfintech.ds.beans.xml.XmlBeanDefinitionReader;

/**
 * @Title: AutowireCapableBeanFactory.java
 * @Description:自动装配类型的IOC容器
 * @Company 招商局金融科技
 * @author 杜松
 * @date 2017年12月21日 上午9:15:54
 * @version V1.0
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
	
	
	public AutowireCapableBeanFactory(String path) throws Exception {
		HashMap<String, BeanDefinition> beanDefinitions=new XmlBeanDefinitionReader().loadBeanDefinitions(path);
		this.beanDefinitions=beanDefinitions;
		this.ioc=new HashMap<String, Object>();
		preInitialization(beanDefinitions);
	}

	/**
	 * @Description:创建Bean
	 * @param beanDefinition
	 * @return
	 * @author 杜松
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @date 2017年12月21日 上午9:16:29
	 */
	@Override
	Object createBean(BeanDefinition beanDefinition)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Object bean = getInstance(beanDefinition);
		bean = SetPropertys(beanDefinition, bean);

		return bean;
	}

	/**
	 * 
	 * @Description:获取bean的初始化实例
	 * @param beanDefinition
	 *            bean定义
	 * @return
	 * @author 杜松
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @date 2017年12月21日 上午10:11:10
	 */
	private Object getInstance(BeanDefinition beanDefinition)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		String name = beanDefinition.getName();
		String className = beanDefinition.getClassName();
		Class clazz = null;

		clazz = Class.forName(className);

		Object bean = clazz.newInstance();
		return bean;

	}

	/**
	 * 
	 * @Description:bean属性装配
	 * @param beanDefinition
	 *            bean定义
	 * @param bean
	 *            bean对象
	 * @return 装配好的bean
	 * @author 杜松
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @date 2017年12月21日 上午9:22:37
	 */
	private Object SetPropertys(BeanDefinition beanDefinition, Object bean)
			throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, InstantiationException {
		List<Property> properties = beanDefinition.getProperties();
		for (Property property : properties) {
			String value = property.getPropertyValue();
			String name = property.getPropertyName();
			String ref = property.getPropertyRef();
			if (value != null && value.length() > 0) {
				HashMap<String, String[]> map = new HashMap<String, String[]>();
				map.put(name, new String[] { value });
				BeanUtils.populate(bean, map);
			} else {
				Object exitbean = ioc.get(ref);
				if (exitbean == null) {

					exitbean = createBean(beanDefinitions.get(ref));
					if (beanDefinitions.get(ref).getScope().equals("singleton")) {
						ioc.put(ref, exitbean);
					}

				}

				BeanUtils.setProperty(bean, name, exitbean);
			}

		}

		return bean;

	}

	/**
	 * 
	 * @Description:提前初始化，用于单例类型的bean
	 * @param beanDefinitions
	 *            定义的bean集合
	 * @return
	 * @author 杜松
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @date 2017年12月21日 上午9:55:25
	 */
 public	void preInitialization(HashMap<String, BeanDefinition> beanDefinitions)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
		for (Entry<String, BeanDefinition> ele : beanDefinitions.entrySet()) {
			String scope = ele.getValue().getScope();
			String name = ele.getKey();
			if (scope.equals("singleton")) {
				Object bean = createBean(ele.getValue());
				ioc.put(name, bean);
			}
		}

	}

}
