package com.spring.datasource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestTx4 {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext7.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	TestTx5 td = context.getBean("testTx5", TestTx5.class);
	td.add();
}
}