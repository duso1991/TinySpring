package com.cmfintech.ds.beans;

/**   
  * @Title: Property.java
  * @Description:Bean属性对象
  * @Company  招商局金融科技
  * @author  杜松   
  * @date 2017年12月20日 下午8:54:32
  * @version V1.0   
*/
public class Property {
	private String propertyName;//属性名称
	private String propertyValue;//属性值
	private String propertyRef;//引用值
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	public String getPropertyRef() {
		return propertyRef;
	}
	public void setPropertyRef(String propertyRef) {
		this.propertyRef = propertyRef;
	}

}
