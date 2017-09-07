package com.liu.util.hiber;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * 分页数据封装
 * Title:
 *
 * Description：
 * 
 * @Author 项国轩
 * @Date 2012-3-8
 * @param <T>
 */
@Component
@Scope("prototype")
public class PageView<T> {

	/** 分页数据 */
	private List<T> records ;
	
	/** 总记录数 */
	private long totalRecord ;
	
	/** 总页数 */
	private long totalPage ;
	
	/** 当前页 */
	private int currentPage = 1;

	/** 每页显示记录数，默认显示记录数为：15 */
	private int maxResult = 15;

	/** 页码数量 */
	private int pageCode = 5 ;
	
	/** 页码开始索引和结束索引 **/
	private PageIndex pageIndex ;
	
	public PageView() {}
	
	/** 获取记录的开始索引  */
	public int getFirstResult() {
		return (this.currentPage - 1) * this.maxResult ;
	}
	
	/** 设置分页数据和总记录数 */
	public void setPageModel(PageModel<T> pm) {
		if(null != pm) {
			this.records = pm.getResultList() ;
			this.totalRecord = pm.getTotalRecord() ;
		}
	}
	
	/** 在获取总页数前，先通过计算获得总页数，并设置总页数的值 */
	public long getTotalPage() {
		this.setTotalPage((this.totalRecord % this.maxResult == 0 ? this.totalRecord / this.maxResult : (this.totalRecord / this.maxResult) + 1)) ;
		return this.totalPage ;
	}
	
	/** 当设置完总页数的值之后，开始计算页码开始索引和结束索引 */
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
		this.pageIndex = PageIndex.getPageIndex(pageCode, currentPage, totalPage) ;
	}
	
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	
	public int getMaxResult() {
		return maxResult;
	}
	
	public int getPageCode() {
		return pageCode;
	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public List<T> getRecords() {
		return records;
	}

	public long getTotalRecord() {
		return totalRecord;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

}
