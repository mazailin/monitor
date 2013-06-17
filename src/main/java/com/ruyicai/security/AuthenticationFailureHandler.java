package com.ruyicai.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.ruyicai.common.utils.LoggerUtil;

public class AuthenticationFailureHandler extends
		SimpleUrlAuthenticationFailureHandler {
	
	
	public AuthenticationFailureHandler() {
		super();
	}

	public AuthenticationFailureHandler(String defaultFailureUrl) {
		super(defaultFailureUrl);
	}

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		request.getSession().setAttribute("authenticationFail", "yes");
		
//		String className = super.getClass().getName();
   	 	String loginName=LoggerUtil.getLoginUserName();
//   	 	String operatePath=className.substring(className.lastIndexOf(".")+1,className.toLowerCase().lastIndexOf("controller"));
//   	 	StringBuffer sb=new StringBuffer();
//   	 	sb.append("  select name from resource where path like '%"+operatePath+"%' ");
   	 	System.out.println("loginName="+loginName);
//   	 	Object  o= resourceDao.findByPathName(sb.toString());
//   	 	String operateName="";
//   	 	if(o!=null){
//   	 		operateName=o.toString();
//   	 	}else{
//   	 		return;
//   	 	}
		
		super.onAuthenticationFailure(request, response, exception);
	}
}
