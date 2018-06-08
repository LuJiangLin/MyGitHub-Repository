package com.fm.utils;
/**
 * 判断是否为空 
 * @author：lujianglin   
 * @time：      2018年3月15日
 */
public class judgeNull {
	    
		public static boolean String(String str){
			if(  str!=null && !str.equals("")){
				return true;
			}else{
				return false;
			}
		}
		
		
		public static boolean Integer(Integer str){
			if(str!=null && str!=0){
				return true;
			}else{
				return false;
			}
		}
		
		public static boolean Double(Double str){
			if( str!=null && str!=0.0){
				return true;
			}else{
				return false;
			}
		}
		
		public static boolean NOtNull(Object obj){
			if(  obj!=null){
				return true;
			}else{
				return false;
			}
		}
		public static void main(String[] args) {
			Double a = 0.00;
			if(!judgeNull.Double(a)){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
			
			
		}
		

}
