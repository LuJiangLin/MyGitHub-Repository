package com.fm.utils;
import java.io.BufferedReader;  
import java.io.DataOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.UnsupportedEncodingException;  
import java.net.HttpURLConnection;  
import java.net.URL;  

import net.sf.json.JSONObject;
/** 
 *  根据IP地址获取详细的地域信息 
 * @author：lujianglin   
 * @time：      2018年4月8日       
 */
public class AddressUtils {
	
	
	 // 测试  
	 public static void main(String[] args) {  
	  AddressUtils addressUtils = new AddressUtils();  
	  String ip = "183.62.131.86";  
	  JSONObject address = new JSONObject();  
	  try {  
		  address = addressUtils.getAddresses("ip="+ip, "utf-8");  
	  } catch (UnsupportedEncodingException e) {  
		  e.printStackTrace();  
	  }  
	  System.out.println(address);  
	  // 输出结果为：json
	  //{"ip":"183.62.131.86","country":"中国","area":"","region":"广东","city":"深圳",
	  //"county":"XX","isp":"电信","country_id":"CN","area_id":"","region_id":"440000",
	  //"city_id":"440300","county_id":"xx","isp_id":"100017"}

	 } 
	
	
	/** 
	  * 获取ip的省市地址
	  * @param content  请求的参数 格式为：name=xxx&pwd=xxx 
	  * @param encoding  服务器端请求编码。如GBK,UTF-8等 
	  * @return 
	  * @throws UnsupportedEncodingException 
	  */  
	 public JSONObject getAddresses(String content, String encodingString)  
	   throws UnsupportedEncodingException {  
	  // 这里调用pconline的接口  
	  String urlStr = "http://ip.taobao.com/service/getIpInfo.php";  
	  // 从http://whois.pconline.com.cn取得IP所在的省市区信息  
	  String returnStr = this.getResult(urlStr, content, encodingString);  
	  if (returnStr != null) {  
	   // 处理返回的省市区信息  
	   System.out.println(returnStr);  
	   String[] temp = returnStr.split(",");  
	   if(temp.length<3){  
	    return null;//无效IP，局域网测试  
	   }  
	   String region ="";
	   String city ="";
	   JSONObject json = JSONObject.fromObject(returnStr);
	   JSONObject obj = new JSONObject();
	   obj =json.getJSONObject("data");
	   region = obj.getString("region");
	   city  = obj.getString("city");
	   return obj;  
	  }  
	  return null;  
	 }  
	 /** 
	  * @param urlStr 
	  *            请求的地址 
	  * @param content 
	  *            请求的参数 格式为：name=xxx&pwd=xxx 
	  * @param encoding 
	  *            服务器端请求编码。如GBK,UTF-8等 
	  * @return 
	  */  
	 private String getResult(String urlStr, String content, String encoding) {  
	  URL url = null;  
	  HttpURLConnection connection = null;  
	  try {  
	   url = new URL(urlStr);  
	   connection = (HttpURLConnection) url.openConnection();// 新建连接实例  
	   connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒  
	   connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒  
	   connection.setDoOutput(true);// 是否打开输出流 true|false  
	   connection.setDoInput(true);// 是否打开输入流true|false  
	   connection.setRequestMethod("POST");// 提交方法POST|GET  
	   connection.setUseCaches(false);// 是否缓存true|false  
	   connection.connect();// 打开连接端口  
	   DataOutputStream out = new DataOutputStream(connection  
	     .getOutputStream());// 打开输出流往对端服务器写数据  
	   out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx  
	   out.flush();// 刷新  
	   out.close();// 关闭输出流  
	   BufferedReader reader = new BufferedReader(new InputStreamReader(  
	     connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据  
	   // ,以BufferedReader流来读取  
	   StringBuffer buffer = new StringBuffer();  
	   String line = "";  
	   while ((line = reader.readLine()) != null) {  
	    buffer.append(line);  
	   }  
	   reader.close();  
	   return buffer.toString();  
	  } catch (IOException e) {  
	   e.printStackTrace();  
	  } finally {  
	   if (connection != null) {  
	    connection.disconnect();// 关闭连接  
	   }  
	  }  
	  return null;  
	 }  
	 /** 
	  * unicode 转换成 中文 
	  * 
	  * @author fanhui 2007-3-15 
	  * @param theString 
	  * @return 
	  */  
	 public static String decodeUnicode(String theString) {  
	  char aChar;  
	  int len = theString.length();  
	  StringBuffer outBuffer = new StringBuffer(len);  
	  for (int x = 0; x < len;) {  
	   aChar = theString.charAt(x++);  
	   if (aChar == '\\') {  
	    aChar = theString.charAt(x++);  
	    if (aChar == 'u') {  
	     int value = 0;  
	     for (int i = 0; i < 4; i++) {  
	      aChar = theString.charAt(x++);  
	      switch (aChar) {  
	      case '0':  
	      case '1':  
	      case '2':  
	      case '3':  
	      case '4':  
	      case '5':  
	      case '6':  
	      case '7':  
	      case '8':  
	      case '9':  
	       value = (value << 4) + aChar - '0';  
	       break;  
	      case 'a':  
	      case 'b':  
	      case 'c':  
	      case 'd':  
	      case 'e':  
	      case 'f':  
	       value = (value << 4) + 10 + aChar - 'a';  
	       break;  
	      case 'A':  
	      case 'B':  
	      case 'C':  
	      case 'D':  
	      case 'E':  
	      case 'F':  
	       value = (value << 4) + 10 + aChar - 'A';  
	       break;  
	      default:  
	       throw new IllegalArgumentException(  
	         "Malformed      encoding.");  
	      }  
	     }  
	     outBuffer.append((char) value);  
	    } else {  
	     if (aChar == 't') {  
	      aChar = '\t';  
	     } else if (aChar == 'r') {  
	      aChar = '\r';  
	     } else if (aChar == 'n') {  
	      aChar = '\n';  
	     } else if (aChar == 'f') {  
	      aChar = '\f';  
	     }  
	     outBuffer.append(aChar);  
	    }  
	   } else {  
	    outBuffer.append(aChar);  
	   }  
	  }  
	  return outBuffer.toString();  
	 }  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
