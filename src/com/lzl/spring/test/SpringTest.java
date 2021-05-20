package com.lzl.spring.test;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lzl.spring.entity.Person;
 
 
public class SpringTest {
	public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Person person = context.getBean("person", Person.class);
			System.out.println(person.toString());
	}
}