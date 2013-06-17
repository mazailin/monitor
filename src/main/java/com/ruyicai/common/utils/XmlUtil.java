package com.ruyicai.common.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


public class XmlUtil {

	public static Element addElement(Element parent, String name,
			String strValue) {
		if (strValue != null) {
			Element child = parent.addElement(name);
			child.setText(strValue);
			return child;
		}
		return null;
	}

	public static Element addElement(Element parent, String name, int intValue) {
		String text = String.valueOf(intValue);
		return addElement(parent, name, text);
	}

	public static Element addElement(Element parent, String name,
			double doubleValue) {

		return addElement(parent, name, doubleValue,null);
	}

	public static Element addElement(Element parent, String name,
			double doubleValue,String pattern) {
		if(Utils.strIsNull(pattern)){
			pattern = "###.##";
		}
		String text = Utils.doubleDecimalFormat(pattern,doubleValue);
		return addElement(parent, name, text);
	}

	public static Element addElement(Element parent, String name, long longValue) {
		return addElement(parent, name, longValue,null);
	}

	public static Element addElement(Element parent, String name, long longValue
		,String pattern) {
		if(Utils.strIsNull(pattern)){
			pattern = "#";
		}
		String text = Utils.longDecimalFormat(pattern,longValue);
		return addElement(parent, name, text);
	}

	public static Element addElement(Element parent, String name, Date dateValue) {
		if (dateValue == null) {
			return null;
		}
		String text = Utils.getDefaultDateFormat().format(dateValue);
		return addElement(parent, name, text);
	}

	public static Element addElement(Element parent, String name,
			boolean booleanValue) {
		String text = String.valueOf(booleanValue);
		return addElement(parent, name, text);
	}
	
	public static void store(String fileName,Document doc) throws IOException {
		
		OutputFormat format = OutputFormat.createPrettyPrint();		
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileWriter(fileName),format);
	    writer.write( doc );
	    writer.close();
	}
	
	public static void store(File file,Document doc) throws IOException {
		
		OutputFormat format = OutputFormat.createPrettyPrint();		
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileWriter(file),format);
	    writer.write( doc );
	    writer.close();
	}
}
