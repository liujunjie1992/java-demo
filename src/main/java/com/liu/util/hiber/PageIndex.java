package com.liu.util.hiber;

/**
 * 
 * Title:分页算法
 *
 * Description：
 * 
 * @Author 项国轩
 * @Date 2012-3-8
 */
public class PageIndex {
	
	/** 开始索引 */
	private long startindex;
	
	/** 结束索引 */
	private long endindex;
	
	public PageIndex(long startindex, long endindex) {
		this.startindex = startindex;
		this.endindex = endindex;
	}
	
	public long getStartindex() {
		return startindex;
	}
	public void setStartindex(long startindex) {
		this.startindex = startindex;
	}
	public long getEndindex() {
		return endindex;
	}
	public void setEndindex(long endindex) {
		this.endindex = endindex;
	}
	
	/**
	 * 
	 * @param pageCode 页面代码，显示多少页
	 * @param currentPage 当前页
	 * @param totalPage 总页数
	 * @return
	 */
	public static PageIndex getPageIndex(long pageCode, int currentPage, long totalPage){
			long startpage = currentPage-(pageCode%2==0? pageCode/2-1 : pageCode/2);
			long endpage = currentPage+pageCode/2;
			if(startpage<1){
				startpage = 1;
				if(totalPage>=pageCode) endpage = pageCode;
				else endpage = totalPage;
			}
			if(endpage>totalPage){
				endpage = totalPage;
				if((endpage-pageCode)>0) startpage = endpage-pageCode+1;
				else startpage = 1;
			}
			return new PageIndex(startpage, endpage);		
	}
	
	/***
	 * 
	 * @param record  每页显示记录数
	 * @param maxrecord  总共记录数
	 * @param pageCode  显示几个页码
	 * @param currentPage  当前第几页
	 * @return
	 */
	public static String getPageIndex2(long record,long maxrecord,long pageCode, int currentPage){
		if(0 == record){
			return "1," ;
		}
		long totalPage = maxrecord % record ==0 ? maxrecord / record : (maxrecord / record )+ 1;
		PageIndex p = getPageIndex(pageCode, currentPage, totalPage);
		StringBuffer sb = new StringBuffer();
		for (long i = p.getStartindex(); i <= p.getEndindex(); i++) {
			sb.append(i);
			sb.append(",");
		}
		return sb.toString();
}
	/***
	 * 
	 * @param record  每页显示记录数
	 * @param maxrecord  总共记录数
	 * @param pageCode  显示几个页码
	 * @param currentPage  当前第几页
	 * @return
	 */
	public static Integer[] getPageIndex3(long record,long maxrecord,long pageCode, int currentPage){
		if(0 == record){
			return new Integer[0] ;
		}
		long totalPage = maxrecord % record ==0 ? maxrecord / record : (maxrecord / record )+ 1;
		PageIndex p = getPageIndex(pageCode, currentPage, totalPage);
		Integer[] in = new Integer[(int)p.getEndindex()-(int)p.getStartindex()+1] ;
		int a = 0 ;
		for (long i = p.getStartindex(); i <= p.getEndindex(); i++) {
			in[a] = (int)i ;
			a++ ;
		}
		return in ;
}
	
	public static void main(String[] args) {
		System.out.println(getPageIndex2(10, 40, 10, 1));
	}
	
	
	
}
