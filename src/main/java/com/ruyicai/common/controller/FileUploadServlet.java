package com.ruyicai.common.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.exception.CCSException;

public class FileUploadServlet extends HttpServlet {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(FileUploadServlet.class);
	private static ApplicationContext ac = null;
	// Initialize global variables
		public synchronized void init() throws ServletException {
			log.warn("DispatchServlet init ...");

			if (ac == null) {
				ac = WebApplicationContextUtils
						.getWebApplicationContext(getServletContext());
			}

		}

		// Clean up resources
		public void destroy() {
			log.warn("DispatchServlet destroy ...");
		}
		// Process the HTTP Get request
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			process(request, response, System.currentTimeMillis());
		}

		// Process the HTTP Post request
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			process(request, response, System.currentTimeMillis());
		}

		protected void process(HttpServletRequest request,
				HttpServletResponse response, long beginTime)
				throws ServletException, IOException {
			// set headers
			response.setCharacterEncoding("UTF-8");

//			if (log.isDebugEnabled()) {
//				Enumeration en = request.getHeaderNames();
//				if (log.isDebugEnabled()) {
//					log.debug("\n\n##############################################");
//				}
//				if (log.isInfoEnabled()) {
//					log.info("Request URI: " + request.getRequestURI() + ", from "
//							+ request.getRemoteAddr() + ":"
//							+ request.getRemotePort());
//				}
//				if (log.isDebugEnabled()) {
//					log.debug("Context Path: " + request.getContextPath());
//					log.debug("Request URL: " + request.getRequestURL().toString());
//					log.debug("Query String: " + request.getQueryString());
//					log.debug("================ HTTP Header ================");
//					/*http have many header contains general \ request \response and entity header*/
//					while (en.hasMoreElements()) {
//						String name = (String) en.nextElement();
//						Enumeration value = request.getHeaders(name);
//						while (value.hasMoreElements()) {
//							log.debug(name + " = " + value.nextElement());
//						}
//					}
//					log.debug("============================================");
//				}
//			}
			/*如果未指定编码格式，指定为UTF-8*/
			if (request.getCharacterEncoding() == null) {
				log.debug("CharacterEncoding is null, set to default 'UTF-8'");
				request.setCharacterEncoding("UTF-8");
			}
			if (log.isDebugEnabled()) {
				log.debug("CharacterEncoding: " + request.getCharacterEncoding());
			}

			// start process
			String cp = request.getContextPath();
			String command = request.getRequestURI();
			if (command.length() >= cp.length()) {
				command = command.substring(cp.length());
				if (command.startsWith("/uploadfile/")) {
					command = command.substring(12);
				}
			}
			//da_sca_update
			if (log.isDebugEnabled()) {
				log.debug("###  >>> Request COMMAND = " + command);
				log.debug("================ HTTP Parameter ================");
				Enumeration en = request.getParameterNames();
				while (en.hasMoreElements()) {
					String key = (String) en.nextElement();
					String[] values = request.getParameterValues(key);
					for (int i = 0; i < values.length; i++) {
						log.debug(key + " = " + values[i]);
					}
				}
				log.debug("================================================");
			}
			try {
				// executing command
				ICommander commander = null;
				
				try {//
					commander = (ICommander) ac.getBean(command);
				} catch (NoSuchBeanDefinitionException e) {
					log.debug("NoSuchBeanDefinitionException: " + command);
					throw new CCSException(
							Contants.CODE_UNSUPPORTED_COMMAND_ERROR);
				}

				if (commander == null) {
					throw new CCSException(
							Contants.CODE_UNSUPPORTED_COMMAND_ERROR);
				}
			 commander.execute(request,response);//更新了数据库的状态

//					sendResponse(request, response, res, beginTime);

			
			} catch (Throwable ex) {
				log.warn("Unknown Error", ex);
			}
		}
}
