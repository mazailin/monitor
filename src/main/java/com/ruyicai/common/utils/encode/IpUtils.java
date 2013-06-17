package com.ruyicai.common.utils.encode;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ruyicai.common.utils.Utils;

public class IpUtils {

	public static Long IpToInt(String ip)
    {
		if(ip==null||"".equals(Utils.trims(ip)))
			return null;
        String separator = "\\.";
        String[] strArray = ip.split(separator);
        if (strArray.length == 4) {
	        long num2 = ((Long.parseLong(strArray[0]) * 0x100L) * 0x100L) * 0x100L;
	        long num3 = (Long.parseLong(strArray[1]) * 0x100L) * 0x100L;
	        long num4 = Long.parseLong(strArray[2]) * 0x100L;
	        long num5 = Long.parseLong(strArray[3]);
	        return (((num2 + num3) + num4) + num5);
        } else {
        	return null;
        }
    }

	public static String IntToIP(long ip_Int) {
		long num = (long) ((ip_Int & 0xff000000L) >> 0x18);
		if (num < 0L) {
			num += 0x100L;
		}
		long num2 = (ip_Int & 0xff0000L) >> 0x10;
		if (num2 < 0L) {
			num2 += 0x100L;
		}
		long num3 = (ip_Int & 0xff00L) >> 8;
		if (num3 < 0L) {
			num3 += 0x100L;
		}
		long num4 = ip_Int & 0xffL;
		if (num4 < 0L) {
			num4 += 0x100L;
		}
		return num + "." + num2 + "." + num3 + "." + num4;
	}
	
	public static void main(String[] args) {
		System.out.println(IpUtils.IntToIP(3232236062L));
		
		System.out.println(IpUtils.IpToInt("192.168.2.30"));
		Date d=new Date(1215139336964L);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
	}

}
