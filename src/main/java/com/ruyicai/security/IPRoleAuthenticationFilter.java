package com.ruyicai.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class IPRoleAuthenticationFilter extends OncePerRequestFilter {

	private List<String> allowedIPAddresses;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res, FilterChain chain)throws ServletException, IOException { 
		 // before we allow the request to proceed, we'll first get the user's role    
	      // and see if it's an administrator    
	      final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();    
	      if (authentication != null) {
	          boolean shouldAllow = false;  
	          String ipAddress = null;
	          try {
	        	  ipAddress = getIpAddr(req);
	        	 
	          }catch (Exception e) { 
	        	  e.printStackTrace();
	          }
	          if(ipAddress==null||"".equals(ipAddress)){}
	          else {
	        	  for(String patternIp : allowedIPAddresses){
	        		  if(patternIp.indexOf("*") != -1){
	        			  patternIp = patternIp.substring(0,patternIp.indexOf("*"));
	        		  }
	        		  patternIp = patternIp.trim();
	        		  if("".equals(patternIp)){//*,全部
	        			  shouldAllow = true ;
	        			  break;
	        		  }
	        		  if(ipAddress.startsWith(patternIp)){//match
	        			  shouldAllow = true ;
	        			  break;
	        		  }
	        	  }
	          } 
              if(!shouldAllow) {
                  throw new AccessDeniedException("Access has been denied for your IP address: "+req.getRemoteAddr());
              }
	      } else {
	        logger.warn("The IPRoleAuthenticationFilter should be placed after the user has been authenticated in the filter chain.");    
	      }
	      chain.doFilter(req, res);      
	        
	}
	private static final String getIpAddr2(final HttpServletRequest request)throws Exception {
		if (request == null) {
			throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
		}
		String ipString = request.getHeader("x-forwarded-for");
		if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
			ipString = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
			ipString = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
			ipString = request.getRemoteAddr();
		}  
		return ipString;
}
	private static final String getIpAddr(final HttpServletRequest request)throws Exception {
			if (request == null) {
				throw (new Exception("getIpAddr method HttpServletRequest Object is null"));
			}
			String ipString = request.getHeader("x-forwarded-for");
			if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)) {
				ipString = request.getHeader("Proxy-Client-IP");
			}
			if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
				ipString = request.getHeader("WL-Proxy-Client-IP");
			}
			if (StringUtils.isBlank(ipString) || "unknown".equalsIgnoreCase(ipString)){
				ipString = request.getRemoteAddr();
			} 
			// 多个路由时，取第一个非unknown的ip
			final String[] arr = ipString.split(",");
			for (final String str : arr) {
				if (!"unknown".equalsIgnoreCase(str)){
					ipString = str;
					break;
				}
			} 
			return ipString;
	}
	public List<String> getAllowedIPAddresses() {
		return allowedIPAddresses;
	}
	public void setAllowedIPAddresses(List<String> allowedIPAddresses) {
		this.allowedIPAddresses = allowedIPAddresses;
	}
	public static void main(String[] args) {
		 String patternIp = "*";
		 System.out.println(patternIp.indexOf("*"));
		 patternIp = patternIp.substring(0,patternIp.indexOf("*"));
		 System.out.println( patternIp);
	}
}
