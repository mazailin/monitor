package com.ruyicai.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class LoggerUtil {

	// 获取登入用户名
	public static String getLoginUserName() {
		Object o=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails =null;
		if(o instanceof UserDetails){
			 userDetails = (UserDetails)o;
			return userDetails.getUsername();
		}else{
			return (String)o;
		}
		
		
	}

	@SuppressWarnings("unchecked")
	public static List<String> getLoginUserAth() {
		Object o=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<String> aus = new ArrayList<String>();
		UserDetails userDetails =null;
		if(o instanceof UserDetails){
			userDetails= (UserDetails) o;
		List auths = new ArrayList(userDetails.getAuthorities());
		for (Object object : auths) {
			aus.add(object.toString());
		}
		}else{
			aus.add((String)o);
		}
		return aus;
	}
	public static String trimString(String s){
		return s.replaceAll("(^[ |　]*|[ |　]*$)", "").replaceAll("　"," ");
	}
}
