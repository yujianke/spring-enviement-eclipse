package testXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.BServiceImpl;
import com.spring.service.TestAutowied;

public class TestAutowired {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	TestAutowied td = context.getBean("testAutowied", TestAutowied.class);
	td.testauto();

}
}
