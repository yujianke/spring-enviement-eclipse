package com.spring.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestTx3 {

public static void main(String[] args) { 	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext7.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	TestAdd2 td = context.getBean("testAdd2", TestAdd2.class);
	td.saveadd();
}
}
