package com.cmfintech.ds.beans.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cmfintech.ds.beans.AbstractBeanDefinitionReader;
import com.cmfintech.ds.beans.BeanDefinition;

/**   
  * @Title: XmlBeanDefinitionReader.java
  * @Description:
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月21日 上午9:15:04
  * @version V1.0   
*/
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

	/**
	 * 
	  *@Description:根据文件位置加载Bean定义
	  *@param location 文件路径
	  *@throws Exception
	  *@author  杜松   
	  *@date 2017年12月21日 上午10:15:22
	 */
	public HashMap<String, BeanDefinition> loadBeanDefinitions(String path) throws Exception {
		//1,获取配置文件输入流
		InputStream inputStream=getInputStrem(path);
		
		//2,从配置文档输入流中选取特定节点
		String xpath="//bean";
		List<Element> elements=parseDocument(inputStream, xpath);
	
		return parseBeanDefinition(elements);
		
	}
	
	
	/**
	 * 
	 * @Description:根据配置文件路径获取配置文件输入流
	 * @param path
	 *            配置文件路径
	 * @return 配置文件输入流
	 * @author 杜松
	 * @date 2017年12月21日 上午10:30:06
	 */
	protected InputStream getInputStrem(String path) {
		return XmlBeanDefinitionReader.class.getResourceAsStream(path);
	}

	/**
	  *@Description:从配置文件输入流中选取特定类型的节点
	  *@param inputStream
	  *@return
	  *@author  杜松   
	 * @throws DocumentException 
	  *@date 2017年12月21日 上午10:58:01  
	*/
	@SuppressWarnings("unchecked")
	List<Element> parseDocument(InputStream inputStream,String xpath) throws DocumentException {
		SAXReader saxReader=new SAXReader();
		Document document=saxReader.read(inputStream);
		
		return document.selectNodes(xpath);
	}

}
