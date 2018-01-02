package com.cmfintech.ds.beans;

import java.util.HashMap;

/**
 * 
  * @Title: BeanDefinitionReader.java
  * @Description:bean定义读取
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月21日 上午10:15:03
  * @version V1.0
 */
public interface BeanDefinitionReader {

	/**
	 * 
	  *@Description:根据文件位置加载Bean定义
	  *@param path 文件路径
	  *@return 
	  *@throws Exception
	  *@author  杜松   
	  *@date 2017年12月21日 上午11:15:09
	 */
    HashMap<String, BeanDefinition> loadBeanDefinitions(String path) throws Exception;
}
