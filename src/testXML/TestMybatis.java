package testXML;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.service.AServiceImpl;

import dao.User;
import dao.UserDao;
public class TestMybatis {
public static void main(String[] args) {
	for (String string : args) {
		System.out.println(string);//�������� java -jar XX.jar ����1 ����2 ����3
	}
	String property = System.getProperty("abc");//��������java -Dabc=value -jar XXX.jar
	System.out.println(property);
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext8.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	  UserDao userDAO = (UserDao) context.getBean("userDao");
      // ���� UserDAO �ķ���
      User user = userDAO.findUserById("Jack");
      // ����û���Ϣ
      System.out.println(user.getPassword() + ":" + user.getUsername());
}
}
