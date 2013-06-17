package com.ruyicai.common.utils.http;

import java.util.ArrayList;
import java.util.List;
/**
 * http 结果解析类
 * @author tsj
 *
 */
public class FileScanStatus {
	private String fileName;
	private String md5;
	private String status;
	private List<Engine> engines = new ArrayList<Engine>();
	



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}


    public List<Engine> getEngines() {
		return engines;
	}

	public void setEngines(List<Engine> engines) {
		this.engines = engines;
	}
	public void addEngine(Engine engine) {
		this.engines.add(engine);
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("filename="+this.fileName);
		sb.append("md5="+this.md5);
		sb.append("status"+this.status);
		sb.append("engines="+this.engines);
		return sb.toString();
	}
}
class Engine{
	private String engineName;
	private String engineStatus;
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	public String getEngineStatus() {
		return engineStatus;
	}
	public void setEngineStatus(String engineStatus) {
		this.engineStatus = engineStatus;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("engineName="+this.engineName);
		sb.append("engineStatus="+this.engineStatus);
		return sb.toString();
	}
}