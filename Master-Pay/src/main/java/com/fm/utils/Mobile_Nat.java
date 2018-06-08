package com.fm.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Mobile_Nat {
	public static void getTel(String mobile) {
		String url = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=%s";
		url = String.format(url, mobile);
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements els = doc.getElementsByClass("tdc2");// 网站的 url 里面标签的 class,后面数字2代表第二个class值
		// 属性的值
//		String area = els.get(1).text().substring(0,2) + "省" + els.get(1).text().substring(3,6);
		String area = els.get(1).text().replace("?", " ");
		System.out.println("归属地：" + area);
		System.out.println("类型：" + els.get(2).text());
	}
	public static String getProvince(String mobile) {
		String url = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=%s";
		url = String.format(url, mobile);
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements els = doc.getElementsByClass("tdc2");// 网站的 url 里面标签的 class,后面数字2代表第二个class值
		// 属性的值
//		String area = els.get(1).text().substring(0,2) + "省" + els.get(1).text().substring(3,6);
		String area = els.get(1).text().replace("?", " ");
		return area;
	}

	public static void main(String[] args) throws IOException {
		String mobile = "18565880246";
		getTel(mobile);
//		for (int i = 0; i < 1000; i++) {
//			getTel(mobile);
//		}
	}
}