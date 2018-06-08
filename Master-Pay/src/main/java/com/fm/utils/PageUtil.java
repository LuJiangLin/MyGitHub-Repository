package com.fm.utils;

import java.io.Serializable;

/**
 * 分页工具类
 * @author y
 *
 */
public class PageUtil implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//每页记录数
	private int pagecount = 20;
	//总记录数
	private int sumcount = 0;
	//总页数
	private int sumpage = 0;
	//当前页数
	private int currentpage = 1;
	
	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
		
		sumpage = sumcount % pagecount == 0 ? sumcount /  pagecount 
				:(sumcount / pagecount + 1);
		if(currentpage < 1)
			currentpage = 1;
		if(currentpage > sumpage)
			currentpage = sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getSumcount() {
		return sumcount;
	}
	public int getSumpage() {
		return sumpage;
	}
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
}
