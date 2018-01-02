package com.cmfintech.ds.test.beans;

import org.junit.Assert;

/**
 * 
  * @Title: OutputService.java
  * @Description:
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月21日 上午11:22:01
  * @version V1.0
 */
public class OutputService {

    private HelloWorldService helloWorldService;

    public void output(){
       helloWorldService.print();
    }

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
}
