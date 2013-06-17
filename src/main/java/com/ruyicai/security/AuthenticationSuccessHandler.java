package com.ruyicai.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.ruyicai.common.utils.LoggerUtil;

public class AuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.setAttribute(MyAuthenticationFailureHandler.TRY_MAX_COUNT, 0);// 增加失败次数
		
		
//		String className = super.getClass().getName();
   	 	String loginName=LoggerUtil.getLoginUserName();
//   	 	String operatePath=className.substring(className.lastIndexOf(".")+1,className.lastIndexOf(".")+15);
//   	 	StringBuffer sb=new StringBuffer();
//   	 	sb.append("  select name from resource where path like '%"+operatePath+"%' ");
//   	 	Object  o= resourceDao.findByPathName(sb.toString());
//   	 	String operateName="";
//   	 	if(o!=null){
//   	 		operateName=o.toString();
//   	 	}else{
//   	 		return;
//   	 	}
   	 	
   	 	super.onAuthenticationSuccess(request, response, authentication);
		
		
	}
}
