package com.cmfintech.ds.beans;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Element;

/**
 * 
 * @Title: AbstractBeanDefinitionReader.java
 * @Description:从配置文件中读取文件
 * @Company 招商局金融科技
 * @author 杜松
 * @date 2017年12月21日 上午10:27:54
 * @version V1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	HashMap<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();

	/**
	 * 
	 * @Description:根据配置文件路径获取配置文件输入流
	 * @param path
	 *            配置文件路径
	 * @return 配置文件输入流
	 * @author 杜松
	 * @date 2017年12月21日 上午10:30:06
	 */
	protected abstract InputStream getInputStrem(String path);
	
	
	/**
	 * 
	  *@Description:从Elements元素中获取bean的定义
	  *@param elements 文档元素集合
	  *@author  杜松   
	  *@date 2017年12月21日 上午10:36:02
	 */
	protected HashMap<String, BeanDefinition> parseBeanDefinition(List<Element> elements){
		for (Element element : elements) {
			BeanDefinition beanDefinition=new BeanDefinition();
			String  name=element.attributeValue("name");
			String  className=element.attributeValue("class");
			String  scope=element.attributeValue("scope");
			List<Element> properties=element.elements("property");
			beanDefinition.setName(name);
			beanDefinition.setClassName(className);
			if (scope!=null&&!scope.equals("singleton")) {
				beanDefinition.setScope(scope);
			}
			if (properties!=null) {
				for (Element ele : properties) {
					Property property=new Property();
					String pName = ele.attributeValue("name");
					String pValue = ele.attributeValue("value");
					String pRef = ele.attributeValue("ref");
					property.setPropertyName(pName);
					property.setPropertyValue(pValue);
					property.setPropertyRef(pRef);
					beanDefinition.getProperties().add(property);
				}
			}
			
			beanDefinitions.put(name, beanDefinition);
		}
		return beanDefinitions;
		
	}

}
