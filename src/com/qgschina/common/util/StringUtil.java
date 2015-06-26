package com.qgschina.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * @author limin
 * @fileName
 * 
 */
public class StringUtil {
	public static final String EMPTY = "";

	/**
	 *  str == null  		return ""
	 *  str.equal("null") 	return ""
	 *  					return str
	 *  */
	public  static String outofnull(String str) {
		if (str == null) {
			str = "";
		} else if (str.toLowerCase().equals("null")) {
			str = "";
		}
		return str.trim();
	}

	 /**
	  *  获取一个UUID字符串,除 '-'
	  *  */
	 public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	  * 左填充
	  * @param str 要左填充的字符串
	  * @param charc 要填充的字符
	  * @param len 所需字符串的长度
	  * @return 填充后的字符串
	  */
	public static String paddingLeft(String str,String charc,int len){
		  StringBuffer sbf = new StringBuffer("");		  
		  for(int i=0;i<len-str.length();i++){
			  sbf.append(charc);
		  }
		  return sbf.toString()+str;
	} 
	 
	/**
	 * 判断字符串是否为空(true:为空 false:不为空)
	 * 
	 * @param inStr
	 * @return
	 */
	public  static boolean isEmpty(String inStr) {
		if (null == inStr || EMPTY.equals(inStr)) {
			return true;
		}
		return false;
	}

   	/**
   	 * 判断str数组中是否包含中文
   	 * */
   	public static boolean containChinese(String str) {
   		for(int i = 0 ; i < str.length() ; i++ ) {
   			if( CharUtil.isChinese(str.charAt(i) ) ) 
   				return true;
   		}
   		return false;
   	}
   	
	/**
	 * 从"abcdefghijklmnopqrstuvwxyz0123456789"中随机生成len位的字符串
	 * */
	public static String randomNumChar(int len) {
		String from = "abcdefghijklmnopqrstuvwxyz0123456789";
		int fromLen = from.length();
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for( int i = 0 ; i < len ; i++ ) {
			buf.append( from.charAt(random.nextInt(fromLen)) );
		}
		return buf.toString();
	}
}
