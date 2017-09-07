package com.liu.util.hiber;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


/***
 * 
 * Title:查询工具类
 *
 * Description：
 * 
 * @Author 项国轩
 * @Date 2012-3-22
 */
public class QueryUtil {
	
	/**
	 * 获得查询数据总数量
	 * @param session 
	 * @param hql
	 * @return Long类型
	 */
	public static Long getListCount(Session session , String hql,List<?> param) {
		Query query = session.createQuery(queryCountHQL(hql)) ;
		
		if(null != param && param.size() > 0) {
			for(int i=0; i<param.size(); i++) {
				query.setParameter(i, param.get(i)) ;
			}
		}
		
		return (Long)query.uniqueResult() ;
	}
	
	/**
	 * 拼装SELECT COUNT(*) XXX查询与
	 * @param hql 
	 * @return Sting类型
	 * @throws AppRuntimeException
	 */
	public static String queryCountHQL(String hql) throws RuntimeException{
		String h = "select count(o) ";
		if(hql.contains("group")){
			hql = hql.substring(0,hql.indexOf("group")-1) ;
			h = "select count(distinct o) ";
		}
		if(hql.contains("order by")){
			hql = hql.substring(0,hql.indexOf("order by")-1) ;
			h = "select count(distinct o) ";
		}
		int index = hql.indexOf("from") ;
		if(index != -1) {
			return h+hql.substring(index) ;
		}
		throw new RuntimeException("select count(*)语句拼装错误...") ;
	}
	
	public static void main(String[] args) {
		String str= "select count(distinct o) from ScenicInfoBean o inner join o.scenic_score s  where by o.scenic_id";
		System.out.println(str.substring(0,str.indexOf("group")));
	}
}
