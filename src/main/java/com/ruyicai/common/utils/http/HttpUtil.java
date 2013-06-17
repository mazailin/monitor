package com.ruyicai.common.utils.http;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.params.SyncBasicHttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.exception.CCSException;
import com.ruyicai.common.utils.Utils;

/**
 * httpClient4 工具类
 * makupNameValuePair 封装参数
 * sendGetRequest   GET请求 返回Map [resultCode=0,resultMsg="md5",resultFiles=List<FileScanStatus>]
 * sendPostRequest   POST请求 返回Map
 * sendPostFileRequest  FILE请求 返回Map
 * response xml= <response command="ScanFile">
<result code="0"  msg="10714e50cea54dc7a227e3eddcd44d57"></result>
</response>
 * @author tsj
 *
 */
public class HttpUtil {
	private static final Log log = LogFactory.getLog(HttpUtil.class);

	private static HttpClient httpClient = null;
	private static final String CHARSET = HTTP.UTF_8;

	private static synchronized HttpClient getHttpClient() {
		if (httpClient != null)
			return httpClient;
		HttpParams params = new SyncBasicHttpParams();

		HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
		HttpProtocolParams.setContentCharset(params, CHARSET);
		HttpConnectionParams.setTcpNoDelay(params, true);
		HttpConnectionParams.setSocketBufferSize(params, 8192);

		// Create and initialize scheme registry
		SchemeRegistry schemeRegistry = SchemeRegistryFactory.createDefault();

		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager(
				schemeRegistry);
		// Increase max total connection to 200
		cm.setMaxTotal(200);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		// Increase max connections for localhost:80 to 50
		// HttpHost localhost = new HttpHost("locahost", 80);
		// cm.setMaxForRoute(new HttpRoute(localhost), 50);

		// Create an HttpClient with the ThreadSafeClientConnManager.
		// This connection manager must be used if more than one thread will
		// be using the HttpClient.

		return httpClient = new DefaultHttpClient(cm, params);
	}

	public static List<NameValuePair> makeNameValuePair(
			HttpServletRequest request) {
		return makeNameValuePair(request, null);
	}

	public static List<NameValuePair> makeNameValuePair(
			HttpServletRequest request, List item) {
		return makeNameValuePair(request, item, null);
	}

	public static List<NameValuePair> makeNameValuePair(
			HttpServletRequest request, List item, List ignores) {

		Enumeration enums = request.getParameterNames();

		List items = new Vector();

		while (enums.hasMoreElements()) {
			String name = (String) enums.nextElement();
			String[] values = request.getParameterValues(name);

			if (!Utils.listIsNull(ignores)) {
				if (ignores.contains(name)) {
					continue;
				}
			}

			if (log.isDebugEnabled()) {
				log.debug("makeNameValuePair(request):" + name + "=");
				log.debug(values);
			}

			if (values != null && values.length > 0) {
				for (int i = 0; i < values.length; i++) {
					if (values[i] != null) {
						items.add(name);
						items.add(values[i]);
					}
				}
			}
		}

		if (!Utils.listIsNull(item)) {
			for (int i = 0; i < item.size(); i++) {
				items.add(item.get(i));
			}
		}

		if (!Utils.listIsNull(items)) {
			return makupNameValuePair(items);
		}

		return null;
	}

	public static List<NameValuePair> makupNameValuePair(List items) { 
		if (Utils.listIsNull(items)) {
			return null;
		} 
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(); 
		for (int i = 0; i < items.size() / 2; i++) {
			nameValuePair.add(new BasicNameValuePair((String) items.get(i * 2),
					(String) items.get(i * 2 + 1)));
		} 
		return nameValuePair;

	}

	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * GET HTTP請求
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param params
	 * @throws ClientProtocolException
	 * @throws IOException
	 */

	public static Map sendGetRequest(String serverIp, int serverPort,
			String url, List<NameValuePair> params) throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}
		String param ="";
		if(params!=null)
			param= URLEncodedUtils.format(params, "UTF-8");
		URI uri = null;
		try {
			uri = URIUtils.createURI("http", serverIp, serverPort, url, param,
					null);
			HttpGet request = new HttpGet(uri);
			return sendRequest(request, true);
		} catch (URISyntaxException e) {
			throw new CCSException(Contants.CODE_XML_INVALID);
		}
	}
	public static Map sendGetRequest(String url) throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: url=" + url );
		}
			HttpGet request = new HttpGet(url);
			return sendRequest(request, true);
	}
	/**
	 * 只支持HTTP的請求 form Post request    //获取状态
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param nameValuePair
	 * @param throwErrors
	 * @return null
	 * @throws FactoryConfigurationError
	 */
//	public static Map sendRequest(HttpUriRequest request, boolean throwErrors) throws PerseusException { 
//		HttpResponse response = null;
//		try {
//			HttpClient client = getHttpClient();
//			response = client.execute(request);
//			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
//				throw new PerseusException(Contants.CODE_SERVER_EERORS);
//			} 
//			XmlContentHandler handler = new XmlContentHandler(); 
//			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
//			SAXParser saxParser = saxParserFactory.newSAXParser(); 
//			XMLReader reader = saxParser.getXMLReader(); 
//			reader.setContentHandler(handler);
//
//			InputSource ins = new InputSource(response.getEntity().getContent()); 
//			// process the reponse stream
//			reader.parse(ins); 
//			
//			log.debug("return stream=\n" + ins.toString());
//
//			return handler.getResultMap();
//
//		} catch (IOException e) {
//			log.error("Access server error: ", e);
//			if (throwErrors) {
//				throw new PerseusException(Contants.CODE_SERVER_EERORS);
//			}
//			return null;
//		} catch (PerseusException ex) {
//			log.error("PerseusException:", ex);
//			throw ex;
//		} catch (Exception ex) {
//			log.error("CODE_XML_INVALID:", ex);
//			if (throwErrors) {
//				throw new PerseusException(Contants.CODE_XML_INVALID);
//			}
//			return null;
//		} finally {
//			HttpEntity entity = response.getEntity();
//			try {
//				EntityUtils.consume(entity);
//			} catch (Exception t2) {
//				// Log this exception. The original exception is more
//				// important and will be thrown to the caller.
//				log.warn("Error consuming content after an exception.", t2);
//			}
//
//		}
//	}

	/**
	 * 仅仅发送一个请求
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param params
	 */
	public static void sendGetRequest_just(String serverIp, int serverPort,String url, List<NameValuePair> params){
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}
		String param ="";
		if(params!=null)
			param= URLEncodedUtils.format(params, "UTF-8");
		URI uri = null;
		try {
			uri = URIUtils.createURI("http", serverIp, serverPort, url, param, null);
			HttpGet request = new HttpGet(uri);
			HttpClient client = getHttpClient();
			client.execute(request);
		} catch (URISyntaxException e) {
			try {
				throw new CCSException(Contants.CODE_XML_INVALID);
			} catch (CCSException e1) { 
				log.debug(e1);
				e1.printStackTrace();
			}
		} catch (ClientProtocolException e) { 
			log.debug(e);
			e.printStackTrace();
		} catch (IOException e) { 
			log.debug(e);
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////  
	/**
	 * 发送请求返回xml，解析之
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param params
	 * @param handler
	 * @throws CCSException
	 */
	public static void sendGetRequest_handlerxml(String serverIp, int serverPort,String url, List<NameValuePair> params,ContentHandler handler) throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}
		try {
		/*String param ="";
		if(params!=null)
			param= URLEncodedUtils.format(params, "UTF-8");
		URI uri = null;
			uri = URIUtils.createURI("http", serverIp, serverPort, url, param, null);*/
			url = "http://"+serverIp+":"+serverPort+"/"+url;
			System.out.println(url);
			HttpGet request = new HttpGet(url);
			sendRequest_handle_xml(request, true,handler);
		} catch (Exception e) {
			throw new CCSException(Contants.CODE_XML_INVALID);
		}
	}
	/**
	 * @param request
	 * @param throwErrors
	 * @param handler
	 * @throws CCSException
	 */
	public static void sendRequest_handle_xml(HttpUriRequest request, boolean throwErrors,ContentHandler handler) throws CCSException { 
		HttpResponse response = null;
		try {
			HttpClient client = getHttpClient();
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new CCSException(Contants.CODE_SERVER_EERORS);
			}  
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); 
			SAXParser saxParser = saxParserFactory.newSAXParser(); 
			XMLReader reader = saxParser.getXMLReader(); 
			reader.setContentHandler(handler); 
			/*BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));
			String line = "";
			while((line = br.readLine())!=null){
				System.out.println(line);
			}*/
			InputSource ins = new InputSource(response.getEntity().getContent()); 
			
			// process the reponse stream
			reader.parse(ins); 
			
			log.debug("return stream=\n" + ins.toString());
 

		} catch (IOException e) {
			log.error("Access server error: ", e);
			if (throwErrors) {
				throw new CCSException(Contants.CODE_SERVER_EERORS);
			} 
		} catch (CCSException ex) {
			log.error("CCSException:", ex);
			throw ex;
		} catch (Exception ex) {
			log.error("CODE_XML_INVALID:", ex);
			if (throwErrors) {
				throw new CCSException(Contants.CODE_XML_INVALID);
			} 
		} finally {
			HttpEntity entity = response.getEntity();
			try {
				EntityUtils.consume(entity);
			} catch (Exception t2) {
				// Log this exception. The original exception is more
				// important and will be thrown to the caller.
				log.warn("Error consuming content after an exception.", t2);
			}

		}
	}
 /////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * POST HTTP 請求
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param formParams
	 */
	public static Document sendPostRequest(String serverIp, int serverPort,
			String url, String xml) throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}

		if (!url.startsWith("http://")) {
			while (url.startsWith("/")) {
				url = url.substring(1);
			}

			url = "http://" + serverIp + ":" + serverPort + "/" + url;
		}
		try {
		 StringEntity entity = new StringEntity(xml);
			
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);
			HttpResponse response = null;
			HttpClient client = getHttpClient();
			response = client.execute(request);
			System.out.println("response.getStatusLine().getStatusCode()=="+response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new CCSException(Contants.CODE_SERVER_EERORS);
			}
			SAXReader builder = new SAXReader();
		
			// source
			InputSource ins = new InputSource(response.getEntity().getContent());
			// stream mandated
			// to UTF-8
			ins.setEncoding("UTF-8"); // set the mandate
			// encoding to the input
			// source
			Document document = builder.read(ins);
			return document;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CCSException(Contants.CODE_XML_INVALID);
		}

	}
	/**
	 * POST HTTP 請求
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param formParams
	 */
	public static Map sendPostRequest(String serverIp, int serverPort,
			String url, List<NameValuePair> formParams) throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}

		if (!url.startsWith("http://")) {
			while (url.startsWith("/")) {
				url = url.substring(1);
			}

			url = "http://" + serverIp + ":" + serverPort + "/" + url;
		}
		HttpEntity entity = null;
		try {
			entity = new UrlEncodedFormEntity(formParams, "UTF-8");
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);

			return sendRequest(request, true);
		} catch (UnsupportedEncodingException e) {

			throw new CCSException(Contants.CODE_XML_INVALID);
		}

	}

	/**
	 * Form　POST 傳送一個文件
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param formParams
	 * @param files
	 * @throws UnsupportedEncodingException
	 */
	public static Map sendPostFileRequest(String serverIp, int serverPort,
			String url, List<NameValuePair> formParams, Map<String, File> files)
			throws CCSException {
		if (log.isDebugEnabled()) {
			log.debug(" prepare to execute: ip=" + serverIp + "  port="
					+ serverPort + "  context=" + url);
		}

		if (!url.startsWith("http://")) {
			while (url.startsWith("/")) {
				url = url.substring(1);
			}

			url = "http://" + serverIp + ":" + serverPort + "/" + url;
		}
		try {
			MultipartEntity entity = formatMultipartEntity(formParams, files);
			HttpPost request = new HttpPost(url);
			request.setEntity(entity);

			return sendRequest(request, true);
		} catch (UnsupportedEncodingException e) {

			throw new CCSException(Contants.CODE_XML_INVALID);
		}

	}

	public static String sendRequestGetStr(
			String url, List<NameValuePair> nameValuePair, boolean throwErrors)
			throws CCSException {

		HttpResponse response = null;

		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
			for (NameValuePair p : nameValuePair) {
				formparams.add(p);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,
					CHARSET);
			// 创建POST请求
			HttpPost request = new HttpPost( url);
			request.setEntity(entity); // 发送请求
			HttpClient client = getHttpClient();
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException("请求失败");
			}
			HttpEntity resEntity = response.getEntity();
			return (resEntity == null) ? null : EntityUtils.toString(resEntity,
					CHARSET);
		} catch (IOException e) {
			log.error("Network.sendRequestGetStr error:", e);
			if (throwErrors) {
				throw new CCSException(Contants.CODE_SERVER_EERORS,
						new String[] { 
								"error.connection" });
			}
			return null;
		} finally {
			HttpEntity entity = response.getEntity();
			try {
				EntityUtils.consume(entity);
			} catch (Exception t2) {
				// Log this exception. The original exception is more
				// important and will be thrown to the caller.
				log.warn("Error consuming content after an exception.", t2);
			}

		}

	}

	/**
	 * 只支持HTTP的請求 form Post request
	 * 
	 * @param serverIp
	 * @param serverPort
	 * @param url
	 * @param nameValuePair
	 * @param throwErrors
	 * @return null
	 * @throws FactoryConfigurationError
	 */
	public static Map sendRequest(HttpUriRequest request, boolean throwErrors)
			throws CCSException {

		HttpResponse response = null;
		try {
			HttpClient client = getHttpClient();
			response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new CCSException(Contants.CODE_SERVER_EERORS);
			}

			XmlContentHandler handler = new XmlContentHandler();
			// get instance from factory
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			// get new parser
			SAXParser saxParser = saxParserFactory.newSAXParser();
			// get reader
			XMLReader reader = saxParser.getXMLReader();

			reader.setContentHandler(handler);

			InputSource ins = new InputSource(response.getEntity().getContent());

			// process the reponse stream
			reader.parse(ins);

			log.debug("return stream=\n" + ins.toString());

			return handler.getResultMap();

		} catch (IOException e) {
			log.error("Access server error: ", e);
			if (throwErrors) {
				throw new CCSException(Contants.CODE_SERVER_EERORS);
			}
			return null;
		} catch (CCSException ex) {
			log.error("PerseusException:", ex);
			throw ex;
		} catch (Exception ex) {
			log.error("CODE_XML_INVALID:", ex);
			if (throwErrors) {
				throw new CCSException(Contants.CODE_XML_INVALID);
			}
			return null;
		} finally {
			HttpEntity entity = response.getEntity();
			try {
				EntityUtils.consume(entity);
			} catch (Exception t2) {
				// Log this exception. The original exception is more
				// important and will be thrown to the caller.
				log.warn("Error consuming content after an exception.", t2);
			}

		}
	}
	
	private static MultipartEntity formatMultipartEntity(
			List<NameValuePair> parameters, Map<String, File> files)
			throws UnsupportedEncodingException {
		MultipartEntity entity = new MultipartEntity();
		for (NameValuePair parameter : parameters) {
			String encodedName = parameter.getName();
			String value = parameter.getValue();
			entity.addPart(encodedName,
					new StringBody(value, Charset.forName("UTF-8")));
		}
		java.util.Iterator it = files.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
			entity.addPart((String) entry.getKey(),
					new FileBody((File) entry.getValue()));
		}
		return entity;
	}

	private static String cleanHeads(String source, String tar) {

		while (source.startsWith(tar)) {
			source = source.substring(tar.length());
		}

		return source;
	}

	private static String cleanRears(String source, String tar) {

		while (source.endsWith(tar)) {
			source = source.substring(0, source.length() - tar.length());
		}

		return source;
	}
}