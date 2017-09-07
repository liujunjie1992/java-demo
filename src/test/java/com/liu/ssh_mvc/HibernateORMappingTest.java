package com.liu.ssh_mvc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liu.bean.Resume;
import com.liu.util.GsonUtils;
import com.liu.util.Spring;

public class HibernateORMappingTest {
	private static SessionFactory sessionFactory;
	
	@BeforeClass
	public static void beforeClass() {
		Spring.xmlInit();
		sessionFactory = (SessionFactory)Spring.getBean("sessionFactory");
	}
	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}
	
	@Test
	public void testShowResume() {
		Session s = sessionFactory.getCurrentSession();
		s.beginTransaction();
		Resume resume = (Resume)s.get(Resume.class, 11);
		s.getTransaction().commit();
		System.out.println(GsonUtils.toJson(resume));
	}
	
	public static void main(String[] args) {
		beforeClass();
	}
}
