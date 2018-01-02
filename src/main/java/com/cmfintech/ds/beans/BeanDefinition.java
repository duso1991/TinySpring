package com.cmfintech.ds.beans;

import java.util.LinkedList;
import java.util.List;

/**   
  * @Title: BeanDefinition.java
  * @Description:Bean定义
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月20日 下午8:49:23
  * @version V1.0   
*/
public class BeanDefinition {
	private String name;//bean名称
	private String className;//类路径名
	private String scope="singleton";//bean的作用类型
	private Object bean;//bean对象
	
	private List<Property> properties=new LinkedList<Property>();//属性对象
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Object getBean() {
		return bean;
	}
	public void setBean(Object bean) {
		this.bean = bean;
	}
	public List<Property> getProperties() {
		return properties;
	}
	

}
