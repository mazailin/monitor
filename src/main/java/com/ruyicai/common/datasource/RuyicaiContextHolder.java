package com.ruyicai.common.datasource;

import org.springframework.util.Assert;
/**
 * ContextHolder是一个和LocalThread绑定的类
 * @author tsj
 */
public class RuyicaiContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setContextHolderData(String contextData) {  
       Assert.notNull(contextData, "Data cannot be null");  
       contextHolder.set(contextData);  
    }  	

    public static String getContextHolderData() {  
	       return (String) contextHolder.get();  
    }
	public static void clearContextHolderData() {
		contextHolder.remove();
	}
}
