package com.liu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {

	static ApplicationContext context;

	public static void xmlInit() {
		context = new ClassPathXmlApplicationContext("spring-hibernate.xml");
	}

	public static Object getBean(String name) {
		return context.getBean(name);
	}
}
