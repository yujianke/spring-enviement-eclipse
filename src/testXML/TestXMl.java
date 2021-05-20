package testXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.service.AServiceImpl;
public class TestXMl {
public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	
    Object bean = context.getBean("bs");
    System.out.println(bean.getClass().getName());

    AServiceImpl as = context.getBean("aService", AServiceImpl.class);
	as.barA();
}
}
