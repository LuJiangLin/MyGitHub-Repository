package com.fm.common;

import java.util.List;

import com.fm.utils.PageUtil;

/**
 * 查询结果
 * 
 * @author 帝血弑天——DDM——
 *
 */
public class ResultQuery<T> extends ResultBase {
	private Integer totalItems; // 总条数

	private List<T> data;
	
	private PageUtil pu;//分页工具类

	
	public PageUtil getPu() {
		return pu;
	}

	public void setPu(PageUtil pu) {
		this.pu = pu;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	/**
	 * 获取起始行
	 * 
	 * @param currPage
	 * @param size
	 * @return
	 */
	public static Integer getStart(Integer currPage, Integer size) {
		Integer start = null;
		if (null != currPage && null != size) {
			start = (currPage - 1) * size;
		}
		return start;
	}
}
