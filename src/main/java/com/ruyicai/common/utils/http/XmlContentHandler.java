package com.ruyicai.common.utils.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ruyicai.common.constants.Contants;

public class XmlContentHandler extends DefaultHandler implements ContentHandler {
	
	private String file = null;
	protected HashMap resultMap = null;
	private FileScanStatus fss=null;   //��ʱ��ŵ����ļ�ɨ��Ľ��
	private List<FileScanStatus> fssList=null; //������Ķ���ļ���ɨ��״̬
	
	public Map getResultMap() {
		return resultMap;
	}
	
	@Override
	public void startDocument() throws SAXException { 
		fssList = new ArrayList<FileScanStatus>();
		resultMap = new HashMap();
	}
	@SuppressWarnings("unchecked")
	public void startElement(String namespace, String localname, String type,Attributes attributes) throws SAXException {
		String key = type.trim(); 
		if (key.equalsIgnoreCase(Contants.XML_ATTR_RESULT)) {
			for (int i = 0; i < attributes.getLength(); i++) { 
				String attrName = attributes.getQName(i);
				if (attrName.equalsIgnoreCase(Contants.XML_ATTR_CODE)) {
					resultMap.put(Contants.XML_RESULT_RESULTCODE,attributes.getValue(attrName));
				}else  if (attrName.equalsIgnoreCase(Contants.XML_ATTR_MSG)) {//�ĵ�û�д���
					resultMap.put(Contants.XML_RESULT_RESULTMSG,attributes.getValue(attrName));
				}
			}	 
		}else  if (key.equalsIgnoreCase(Contants.XML_ATTR_FILE)) {
			fss=new FileScanStatus();  
			for (int i = 0; i < attributes.getLength(); i++) { 
				String attrName = attributes.getQName(i);
				if (attrName.equalsIgnoreCase(Contants.XML_ATTR_NAME)) {
					fss.setFileName(attributes.getValue(attrName));
				}else  if (attrName.equalsIgnoreCase(Contants.XML_ATTR_MD5)) {
					fss.setMd5(attributes.getValue(attrName));
				}else if(attrName.equalsIgnoreCase(Contants.XML_ATTR_STATUS)){
					fss.setStatus(attributes.getValue(attrName));
				}
			}		 
		}else if(key.equalsIgnoreCase(Contants.XML_ATTR_ENGINE)){
			Engine engine  = new Engine();
			for (int i = 0; i < attributes.getLength(); i++) {  
				String attrName = attributes.getQName(i);
				if (attrName.equalsIgnoreCase(Contants.XML_ATTR_NAME)) { 
					engine.setEngineName(attributes.getValue(attrName));
				}else  if (attrName.equalsIgnoreCase(Contants.XML_ATTR_STATUS)) {
					engine.setEngineStatus(attributes.getValue(attrName));
				}
			}
			fss.addEngine(engine);
		} 
	}

	public void endElement(String namespace, String localname, String type) throws org.xml.sax.SAXException {
		String key = type.trim();
		if(key.equals(Contants.XML_ATTR_FILE)){
			fssList.add(fss);
		}else if(key.equals(Contants.XML_ATTR_RESULT)){
			resultMap.put(Contants.XML_RESULT_RESULTFILES,fssList);
		}
	}

//	public void characters(char[] ch, int start, int len) {
//		if (key != null) {
//		String text = new String(ch, start, len);
//		String text1 = text.trim();
//		if (text1.length() > 0) {
//		
//				resultMap.put(key, text1);
//				key = null;
//			}
//		}
//	}

}
