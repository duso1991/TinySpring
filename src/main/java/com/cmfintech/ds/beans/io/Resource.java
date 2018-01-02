package com.cmfintech.ds.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
  * @Title: Resource.java
  * @Description:Spring抽象资源接口
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月21日 上午10:21:19
  * @version V1.0
 */
public interface Resource {

	/**
	 * 
	  *@Description:
	  *@return
	  *@throws IOException
	  *@author  杜松   
	  *@date 2017年12月21日 上午10:24:47
	 */
    InputStream getInputStream() throws IOException;
}
