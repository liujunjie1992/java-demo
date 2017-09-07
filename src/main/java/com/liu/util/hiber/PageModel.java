package com.liu.util.hiber;

import java.util.List;

/**
 * 
 * Title:分页数据封装
 *
 * Description：
 * 
 * @Author 项国轩
 * @Date 2012-3-8
 * @param <T>
 */
public class PageModel<T> {

	/** 总记录数 */
	private long totalRecord ;
	
	/** 分页数据 */
	private List<T> resultList ;

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	
	
	
}
