package com.cmfintech.ds.beans.factory;

import java.lang.reflect.InvocationTargetException;

/**   
  * @Title: BeanFactory.java
  * @Description:IOC容器接口
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月20日 下午9:02:38
  * @version V1.0   
*/
public interface BeanFactory {
	
	/**
	 * 
	  *@Description:根据bean名获取Bean
	  *@param name 查询的bean名称
	  *@return Object  bean对象 
	  *@author  杜松   
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws InvocationTargetException 
	  *@date 2017年12月20日 下午9:03:52
	 */
	Object getBean(String name) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;
	

}
