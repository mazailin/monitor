package com.ruyicai.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ruyicai.common.constants.Contants;

/**
 * parse config xml file to json string
 * 
 * @author Tim
 * 
 */
//@Component
public class ConfigUtil {
	private static Logger logger = Logger.getLogger(ConfigUtil.class);

	private static Document doc;
	private String file;

	public static String pageTitle;
	public static String pageTitleLeft;
	public static String pageTitleRigh;
	public static String style;

	/**
	 * tree={
	 * 'accordions':[{'id':'001','title':'PDP监测','collapsed':true,'autoScroll':true}"],001:[{'id':'001001','moduleId':'pdpActiveNew','iconCls':'no-node-icon','draggable':false,'text':'PDP激活创建记录','leaf':false,'childre
	 * n ' : [ ] } ] }
	 */
	public static String tree;

	public static String headmenue;

	public void setFile(String file) {
		this.file = file;
	}

	public static void main(String[] args) {
		ConfigUtil cu = new ConfigUtil();
		try {
			cu.setFile("resources/" + Contants.CONFIG_TREE_XML);
			 cu.initIt();
			System.out.println("System.out.println==" + headmenue);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			if (logger.isDebugEnabled())
				logger.debug("cException:", e);
		}
	}

//	@PostConstruct
	public void initIt() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Init method after properties are set : ");
		// Properties config = new Properties();
		try {
			String separator = File.separator;
			String filePath = "";
			if ("\\".equals(separator)) {
				filePath = Thread.currentThread().getContextClassLoader()
						.getResource("").getPath().substring(1);
			} else {
				filePath = Thread.currentThread().getContextClassLoader()
						.getResource("").getPath();
			}
			System.out.println(filePath);
			filePath = filePath.replaceAll("%20", " ");

			if (file == null)
				file = filePath + Contants.CONFIG_TREE_XML;

			if (logger.isDebugEnabled())
				logger.debug("Init method init file path : " + file);
			// File file = new File(filePath + "treeconfig.properties");
			// config.load(new FileInputStream(file));
		} catch (Exception e) {
			if (logger.isDebugEnabled())
				logger.debug("can not found config file:" + file);
			e.printStackTrace();
		}
		loadByDom4j(file);
	}

	/**
	 * dom4j
	 */
	private void loadByDom4j(String file) {
		long lasting = System.currentTimeMillis();
		try {
			SAXReader reader = new SAXReader();
			org.dom4j.Document doc = reader.read(file);
			Element root = doc.getRootElement();
			pageTitle = root.elementText(Contants.PAGETITLE_TAG);
			pageTitleLeft = root.elementText(Contants.PAGETITLELEFT_TAG);
			pageTitleRigh = root.elementText(Contants.PAGETITLERIGHT_TAG);
			style = root.elementText(Contants.STYLE_TAG);
			List<Element> list = root.element(Contants.TREE_TAG).elements();
			List<Element> validlisttree = new ArrayList<Element>();
			List<Element> validlistheader = new ArrayList<Element>();
			for (Element el : list) {
				if ("true".equals(el.attributeValue(Contants.VALID_ATTR))) {
					if ("true".equals(el.attributeValue(Contants.HEAD_ATTR)))
						validlistheader.add(el);
					else
						validlisttree.add(el);
				}
			}

			StringBuffer trees = new StringBuffer("{");
			StringBuffer sbaccordion = new StringBuffer("'accordions':[");
			StringBuffer sbnode = new StringBuffer();
			processRootElements(validlisttree, sbaccordion, sbnode,false);
			sbaccordion.append("]");
			trees.append(sbaccordion.toString());
			trees.append(",");
			trees.append(sbnode.toString());
			trees.append("}");
			StringBuffer head = new StringBuffer("{");
			StringBuffer hdaccordion = new StringBuffer("'accordions':[");
			StringBuffer hdnode = new StringBuffer();
			processRootElements(validlistheader, hdaccordion, hdnode,true);
			hdaccordion.append("]");
			head.append(hdaccordion.toString());
			head.append(",");
			head.append(hdnode.toString());
			head.append("}");
			tree = trees.toString();
			headmenue = head.toString();
		} catch (Exception e) {
			e.printStackTrace();
			if (logger.isDebugEnabled())
				logger.debug("can not load xml resource.", e);
		}
		// System.out.println("load2运行时间："
		// + (System.currentTimeMillis() - lasting) + "毫秒");

	}

	private void processRootElements(List<Element> elementList,
			StringBuffer sbaccordion, StringBuffer sbnode,boolean isHead) {

		for (int i = 0; i < elementList.size(); i++) {
			Element el = elementList.get(i);

			String id = el.attributeValue(Contants.ID_ATTR);
			String text = el.attributeValue(Contants.TEXT_ATTR);
			String moduleId = el.attributeValue(Contants.MODULEID_ATTR);
			String params = el.attributeValue(Contants.PARAMS_ATTR);
			String iconCls = el.attributeValue(Contants.ICONCLS_ATTR);
			String draggable = el.attributeValue(Contants.DRAGGABLE_ATTR);
			String leaf = el.attributeValue(Contants.LEAF_ATTR);
			String order = el.attributeValue(Contants.ORDER_ATTR);
			sbaccordion.append("{'id':'" + id + "','title':'" + text
					+ "','collapsed':false,'autoScroll':true}");
			if(order==null)order=i+"";
			if(isHead){
				String sql="INSERT INTO `resource`(`id`,`name`,`path`,`parent`,`leaf`,`displayorder`,`headermenu`) VALUES ('"
						+ id
						+ "','"
						+ text
						+ "','"
						+ moduleId
						+ "','0',0,"+ order + ",1);";
				System.out.println(sql);
			
			}else{
				String sql="INSERT INTO `resource`(`id`,`name`,`path`,`parent`,`leaf`,`displayorder`) VALUES ('"
						+ id
						+ "','"
						+ text
						+ "','"
						+ moduleId
						+ "','0',0,"
						+ order + ");";
				System.out.println(sql);
				
			}
			if (i < elementList.size() - 1)
				sbaccordion.append(",");
			if (el.elements().size() > 0) {
				sbnode.append("'" + id + "':[");
				processElements(el.elements(), sbnode);
				sbnode.append("]");
				if (i < elementList.size() - 1)
					sbnode.append(",");
			}
		}

	}

	private void processElements(List<Element> elementList, StringBuffer sbnode) {
		for (int i = 0; i < elementList.size(); i++) {
			Element el = elementList.get(i);
			// {'id':'001001','moduleId':'pdpActiveNew','iconCls':'no-node-icon','draggable':false,'text':'PDP激活创建记录','leaf':false,'children':[]}
			String id = el.attributeValue(Contants.ID_ATTR);
			String moduleId = el.attributeValue(Contants.MODULEID_ATTR);
			String params = el.attributeValue(Contants.PARAMS_ATTR);
			String iconCls = el.attributeValue(Contants.ICONCLS_ATTR);
			String draggable = el.attributeValue(Contants.DRAGGABLE_ATTR);
			String text = el.attributeValue(Contants.TEXT_ATTR);
			String leaf = el.attributeValue(Contants.LEAF_ATTR);
			String order = el.attributeValue(Contants.ORDER_ATTR);
			String parent = "0";
			String lesfq = "0";
			if(order==null)order="100";
			if ("true".equals(leaf))
				lesfq = "1";
			else
				lesfq = "0";
			if (id.length() > 3)
				parent = id.substring(0, id.length() - 3);
			String sql="INSERT INTO `resource`(`id`,`name`,`path`,`parent`,`leaf`,`params`,`displayorder`) VALUES ('"
					+ id
					+ "','"
					+ text
					+ "','"
					+ moduleId
					+ "','"
					+ parent + "'," + lesfq + ",'" + params + "',"+order+");";
			System.out.println(sql);

			sbnode.append("{'id':'" + id + "','" + Contants.MODULEID_ATTR
					+ "':'" + moduleId + "','" + Contants.PARAMS_ATTR + "':'"
					+ params + "','iconCls':'" + iconCls + "','draggable':"
					+ draggable + ",'text':'" + text + "','leaf':" + leaf + "");
			if (el.elements().size() > 0) {
				sbnode.append(",'children':[");
				processElements(el.elements(), sbnode);
				sbnode.append("]}");

			} else {
				sbnode.append(",'children':[]}");
			}
			if (i < elementList.size() - 1)
				sbnode.append(",");
		}
	}

	@PreDestroy
	public void cleanUp() throws Exception {
		if (logger.isDebugEnabled())
			logger.debug("Spring Container is destroy! Customer clean up");
		doc = null;
		pageTitle = null;
		pageTitleLeft = null;
		pageTitleRigh = null;
		style = null;
	}

	private static String getTagValue(String sTag, org.w3c.dom.Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}

}
