package com.spring.datasource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestTx2 {

public static void main(String[] args) { 	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext6.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	TestAdd td = context.getBean("testAdd", TestAdd.class);
	td.saveadd();
}
}
