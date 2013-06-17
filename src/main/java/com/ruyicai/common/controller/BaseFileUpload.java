package com.ruyicai.common.controller;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ruyicai.common.utils.encode.MD5Util;
import com.ruyicai.common.utils.props.Props;

public class BaseFileUpload extends BaseController implements ICommander  {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Properties pro = Props.instance().get();
		String filepath=pro.getProperty("samplesrootpath");
		String singlescanpath=pro.getProperty("ftp.dir.singlescan","single");
		File dir = new File(filepath);
   	 if(!dir.exists()){
   		 dir.mkdirs();
   	 }
   	  dir = new File(filepath+"/"+singlescanpath);
   	 if(!dir.exists()){
   		 dir.mkdirs();
   	 }
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置内存缓冲区，超过后写入临时文件
			factory.setSizeThreshold(10240000); 
			// 设置临时文件存储位置
			factory.setRepository(dir);
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置单个文件的最大上传值
			upload.setFileSizeMax(10002400000l);
			// 设置整个request的最大值
			upload.setSizeMax(10002400000l);
			upload.setHeaderEncoding("UTF-8");
			
			try {
				List<?> items = upload.parseRequest(request);
				FileItem item = null;
				String fileName = null;
				for (int i = 0 ;i < items.size(); i++){
					item = (FileItem) items.get(i);
					fileName = filepath+File.separator+singlescanpath+ File.separator + item.getName();
					// 保存文件
					if (!item.isFormField() && item.getName().length() > 0) {
						 File filefullname =new File(fileName);
						item.write(filefullname);
						 String md5= MD5Util.getFileMD5String(filefullname);
			        	 File f=new File(dir,md5);
			        	
			        	Thread.sleep(5000);
			             filefullname.renameTo(f);
			        	
					}
				}
	        	
	        	 
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


}
