package com.cmfintech.ds.test.beans;

/**
 * 
  * @Title: HelloWorldService.java
  * @Description:用于测试的bean
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月21日 上午11:19:41
  * @version V1.0
 */
public class HelloWorldService {

	private String text;

	public void setText(String text) {
		this.text = text;
	}

	public void print() {
		System.out.println("Hello World！");
	}
}
