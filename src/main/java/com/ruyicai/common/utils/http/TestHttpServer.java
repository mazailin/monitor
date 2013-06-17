package com.ruyicai.common.utils.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestHttpServer {

		private static final Log log = LogFactory.getLog(TestHttpServer.class);



		@RequestMapping(value = "/xml", method = RequestMethod.GET)
		@ResponseBody
		public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// set headers
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/xml; charset=UTF-8");

			String tid = request.getHeader("X-Transaction-ID");
			String addr = request.getHeader("X-Client-Address");

			
				response.addHeader("X-Client-Address", tid);
			
			
				response.addHeader("X-Client-Address", addr);
			
			if (log.isDebugEnabled()) {
				Enumeration en = request.getHeaderNames();
				if (log.isDebugEnabled()) {
					log.debug("\n\n##############################################");
				}
				if (log.isInfoEnabled()) {
					log.info("Request URI: " + request.getRequestURI() + ", from "
							+ request.getRemoteAddr() + ":"
							+ request.getRemotePort());
				}
				if (log.isDebugEnabled()) {
					log.debug("Context Path: " + request.getContextPath());
					log.debug("Request URL: " + request.getRequestURL().toString());
					log.debug("Query String: " + request.getQueryString());
					log.debug("================ HTTP Header ================");
					while (en.hasMoreElements()) {
						String name = (String) en.nextElement();
						Enumeration value = request.getHeaders(name);
						while (value.hasMoreElements()) {
							log.debug(name + " = " + value.nextElement());
						}
					}
					log.debug("============================================");
				}
			}
			if (request.getCharacterEncoding() == null) {
				log.debug("CharacterEncoding is null, set to default 'UTF-8'");
				request.setCharacterEncoding("UTF-8");
			}
			if (log.isDebugEnabled()) {
				log.debug("CharacterEncoding: " + request.getCharacterEncoding());
			}

		    
			sendResponse(request, response,  System.currentTimeMillis());  
		}

		

		

		private static void sendResponse(HttpServletRequest httpRequest, HttpServletResponse httpResponse, long beginTime) throws IOException {
			Element res = DocumentHelper.createElement("response");
			Element result = DocumentHelper.createElement("result");
			result.addAttribute("code","0");
			
			res.add(result);
			String op=httpRequest.getParameter("Op");//ScanFile,ScanDir GetState
			String fileName=httpRequest.getParameter("FileName");
			String updateAll=httpRequest.getParameter("UpdateAll");
			String dir=httpRequest.getParameter("Dir");
			String append=httpRequest.getParameter("Append");
			String md5=httpRequest.getParameter("MD5");
			String msg="";
			System.out.println("op="+op+"fileName="+fileName+"updateAll="+updateAll+"dir="+dir+"append=="+append+"md5="+md5);
			if("ScanFile".equals(op)){
				res.addAttribute("command", "ScanFile");
				msg="MD5";
				result.addAttribute("msg",msg);
			}else if("ScanDir".equals(op)){
				res.addAttribute("command", "ScanDir");
				msg="processing";
				result.addAttribute("msg",msg);
			}else if("GetState".equals(op)){
				res.addAttribute("command", "GetState");
				
				Element file = DocumentHelper.createElement("file");
				file.addAttribute("name","001");
				file.addAttribute("MD5","10714e50cea54dc7a227e3eddcd44d57");
				file.addAttribute("status1","processing");
				file.addAttribute("status2","processing");
				file.addAttribute("status3","processing");
				Element engine = DocumentHelper.createElement("engine");
				engine.addAttribute("name","360");
				engine.addAttribute("status","uploading");
				file.add(engine);
				Element engine2 = DocumentHelper.createElement("engine");
				engine2.addAttribute("name","netQing");
				engine2.addAttribute("status","ok");
				file.add(engine2);
				Element engine3 = DocumentHelper.createElement("engine");
				engine3.addAttribute("name","virustotal");
				engine3.addAttribute("status","uploading");
				file.add(engine3);
				Element engine4 = DocumentHelper.createElement("engine");
				engine4.addAttribute("name","eversec");
				engine4.addAttribute("status","scanning");
				file.add(engine4);
				result.add(file);
			}else {
				
			}
			
			String xmlLine = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			String timeComment = "<!-- 1Time takes: "
					+ (1.0 * (System.currentTimeMillis() - beginTime) / 1000L)
					+ " seconds -->";
			String xml = null;

			Object parameters = "";
			if (parameters instanceof String) {
			
				
				

				try {
					Document doc = DocumentHelper.parseText((String) parameters);
					res.add(doc.getRootElement());
				} catch (DocumentException ex) {
					log.warn("DocumentException", ex);
					res.addElement("parameters");
				}
				xml = res.asXML();

			} 

			int contentLength = xml.getBytes(httpResponse.getCharacterEncoding()).length
					+ timeComment.getBytes(httpResponse.getCharacterEncoding()).length
					+ xmlLine.getBytes(httpResponse.getCharacterEncoding()).length;

			httpResponse.setContentLength(contentLength);

			PrintWriter out = httpResponse.getWriter();
			out.print(xmlLine);
			out.print(timeComment);
			out.print(xml);
			out.flush();
			if (log.isDebugEnabled()) {
				log.debug("Content Length = " + contentLength + "\n" + xml);
			}
			
		}
		


	}


