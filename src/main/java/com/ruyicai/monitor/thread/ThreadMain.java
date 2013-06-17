package com.ruyicai.monitor.thread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.ruyicai.monitor.jms.Torder;

public class ThreadMain {
private static final Map<String,Torder> cachedOrder=new ConcurrentHashMap<String,Torder>(256);
    public static synchronized Torder get(String key){
    return	cachedOrder.get(key);
    }
    public static synchronized void remove(String key){
    	cachedOrder.remove(key);
    }
    public static synchronized void put(String key,Torder o){
    	cachedOrder.put(key, o);
    }
    public static synchronized Map<String,Torder> getall(){
    	Map<String,Torder> ca=new HashMap<String,Torder>();
    	Iterator<Entry<String, Torder>> iter = cachedOrder.entrySet().iterator();
    	while (iter.hasNext()) {
    		Entry<String, Torder> entry =  iter.next();
    		String key = entry.getKey();
    		Torder value = entry.getValue();
    		ca.put(key, value);
           } 
    	
    	return ca;
    }
}
