package com.cmfintech.ds.test.beans;

import java.util.HashMap;
import java.util.Map.Entry;

import com.cmfintech.ds.beans.BeanDefinition;
import com.cmfintech.ds.beans.factory.AutowireCapableBeanFactory;
import com.cmfintech.ds.beans.xml.XmlBeanDefinitionReader;

/**
 * @Title: HelloTest.java
 * @Description:
 * @Company 招商局金融科技
 * @author 杜松
 * @date 2017年12月21日 上午11:25:40
 * @version V1.0
 */
public class HelloTest {
	public static void main(String[] args) throws Exception {
		String path = "/tinyioc.xml";

		// 初始化单例
		AutowireCapableBeanFactory autowireCapableBeanFactory = new AutowireCapableBeanFactory(path);

		HelloWorldService helloWorldService = (HelloWorldService) autowireCapableBeanFactory.getBean("helloWorldService");
		helloWorldService.print();

		OutputService outputService = (OutputService) autowireCapableBeanFactory.getBean("outputService");
		outputService.output();
		

	}
}
