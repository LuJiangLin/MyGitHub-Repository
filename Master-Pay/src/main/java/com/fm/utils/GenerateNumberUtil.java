package com.fm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 编号生成公共类
 * @author y
 *
 */
public class GenerateNumberUtil {
	/*
	 卡池设备编号             P 170831104443 90460	P+yymmddHHMMSS+微秒后5位  共16位
	sim卡编号                 S 170831104443 90460	S+yymmddHHMMSS+微秒后5位  共16位
	 
	 
	 
	供应商编码                         年2位+月2位+日2位+秒+毫秒   取前十位  17 09 27 1234=总共10位
	商品编码  		   0224 170830 145549 589		分类+yymmdd HHMMSS ms(3位)
	订单编码			D 170831104443 1790460	D+yymmddHHMMSS+微秒后7位
	采购单号			20170831 104403 890 yyyymmdd HHMMSS ms(3位)
	入库单号			20170815 160528 495 yyyymmdd HHMMSS ms(3位)
	出库单号			20170823 202802 665 yyyymmdd HHMMSS ms(3位)
	调拨单号			20170818 093238 239 yyyymmdd HHMMSS ms(3位)
	促销编码			20170830 164446 467 yyyymmdd HHMMSS ms(3位)
	退款单号			TK 20170815 160528 495 TK+yyyymmdd HHMMSS ms(3位)
	*/
	
	/*填写外网ip、卡池ip、卡池端口号
	 * 外网地址ID+内网ip最后一段+端口号+卡槽号
	 * 生成卡池编号信息：C001-199-6666
	 * 批量生成卡槽编号：C001-199-6666-001 ~ C001-199-6666-256
	*/
	public static void main(String[] args) {
		
		String extranet = "183.62.131.86";
		String intranet = "192.168.1.199";
		String port ="6666";
		String[] net = intranet.split(".");
		System.out.println(net.toString());
		for (int i = 0; i < net.length; i++) {
			String string = net[i];
			System.out.println(string);
		}
		
		
		
	}
	/**
	 * 卡池设备编号
	 * @return
	 */
	public static String getCardPoolNo(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmm");
		return "P"+sdf.format(new Date())+""+String.valueOf(System.nanoTime()).substring(8,13);
	}
	/**
	 * sim卡编号
	 * @return
	 */
	public static String getSimCardNo(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmm");
		return "S"+sdf.format(new Date())+""+String.valueOf(System.nanoTime()).substring(8,13);
	}
	
	/**
	 * 生成用户订单编号
	 * 格式为(年2 月2 日2 时2 分2 秒2 纳秒13 =总共25位)
	 * @return
	 */
	public static String getOrderNumber(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		return "D"+sdf.format(new Date())+""+String.valueOf(System.nanoTime()).substring(6,13);
	}
	/**
	 * 生成用户退款单号
	 * 格式为(TK 2017年02 月02 日02 时02 分02 秒200 毫秒  =总共19位)
	 * @return
	 */
	public static String getOrderRefundNumber(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssms");
		return "TK"+sdf.format(new Date());
	}
	/**
	 * 生成售后单号
	 * 格式为(SH 2017年02 月02 日02 时02 分02 秒200 毫秒  =总共19位)
	 * @return
	 */
	public static String getAfterSalesNo(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssms");
		return "SH"+sdf.format(new Date());
	}
	/**
	 * 生成售后入库单号
	 * 格式为(TK 2017年02 月02 日02 时02 分02 秒200 毫秒  =总共19位)
	 * @return
	 */
	public static String getAfterSalesNoIn(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssms");
		return "SHRK"+sdf.format(new Date());
	}
	/**
	 * 生成售后出库单号
	 * 格式为(TK 2017年02 月02 日02 时02 分02 秒200 毫秒  =总共19位)
	 * @return
	 */
	public static String getAfterSalesNoOut(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssms");
		return "SHCK"+sdf.format(new Date());
	}
	/**
	 * 生成供应商编码
	 * 格式为(年2位+月2位+日2位+秒+毫秒   取前十位  1709271234=总共10位)
	 * @return
	 */
	public static String getSupplierNo(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddssms");
        String supplierId =  sdf.format(new Date()).substring(0,10);
		return supplierId;
	}
	
	/**
	 * 核销记录单号 HX yyMMddHHmmssSS  (HX17101315085937) 取时间前14位
	 * @return
	 */
	public static String getDeductionNo(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssms");// 可以方便地修改日期格式
		return "HX"+dateFormat.format(new Date()).substring(0,14);
	}
	
	/**
	 * 分配合作商关系编号  yyMMddHHmmss
	 * @return 
	 */
	public static String getSalesmanNo(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		return dateFormat.format(new Date());
	}
	
	/**
	 * 佣金编号(yyMMddHHmmss)
	 * @return
	 */
	public static String getCommissionNo(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		return dateFormat.format(new Date());
	}
	
	
	
	
	  /**
       * 交换数组内所有相邻元素
       * 
       * @param nums
       */ 
	public static String exchange(String str){
         // 使用了java.text.CharacterIteraoter类来迭代字符串
         CharacterIterator ci = new StringCharacterIterator(str);
         int[] nums = new int[str.length()];// 创建一个数组， 他的长度等于字符串的长度
         int i = 0;
         for (char ch = ci.first(); ch != CharacterIterator.DONE; ch = ci.next())
         {
             // 判断当前字符是否为数字
             if (Character.isDigit(ch))
             {
                 int n = Integer.parseInt(String.valueOf(ch));
                 nums[i++] = n;
             }
         }
         //System.out.println(Arrays.toString(nums));
         switch2(nums);
         String str0 = Arrays.toString(nums);
         String[] str1 = str0.split(",");
         String str2 = "";
         for (int k = 0; k < str1.length; k++) {
     	     str2 +=str1[k];
 	    }
        String str3 = str2.substring(1, str2.length()-1);
       // System.out.println(nums.toString()+"----"+str2+"----"+str3);
		return str3.replace(" ", "");
    	
    }
    
    /**
     * 颠倒数组内所有相邻元素
     * 
     * @param nums
     */
    private static void switch2(int[] nums){
    	for(int i = 0; i< nums.length; i++){
    		int tmp = nums[i+1];
    		nums[i+1] = nums[i];
    		nums[i] = tmp;
    		i++;
    	}
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
