package com.ruyicai.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DeepCopyUtil {
	public static Object deepCopy(Object src){
		Object dest = null;
		try {
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(byteOut);
			out.writeObject(src);
			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
			ObjectInputStream in =new ObjectInputStream(byteIn);
			dest  = in.readObject();
		} catch (IOException e) { 
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
			return null;
		}
		return dest;
	}
}
