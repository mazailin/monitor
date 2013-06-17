package com.ruyicai.common.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.ruyicai.common.constants.Contants;

//@Aspect
//@Component
public class DataAspect {
	/**
	 * 数据源切换AOP，根据报名中的第三个字段来判断
	 * 
	 * @param joinpoint
	 *            ：连接点类本身
	 */
	//@Before("within(com.ruyicai.*.service.impl.**)")
	public void beforexue(JoinPoint joinpoint) {
		String className = joinpoint.getSignature().getDeclaringTypeName();
//		System.out.println("className-------------------" + className);
		if(className.contains(".wininfo."))
			RuyicaiContextHolder.setContextHolderData(Contants.MODEL_ID_AGC);
		else
			RuyicaiContextHolder.setContextHolderData(Contants.MODEL_ID_DEFAULT);
		
//		System.out.println("-------------------"+RuyicaiContextHolder.getContextHolderData());
	}
}
