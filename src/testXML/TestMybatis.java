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
		System.out.println(string);//启动命令 java -jar XX.jar 参数1 参数2 参数3
	}
	String property = System.getProperty("abc");//启动明亮java -Dabc=value -jar XXX.jar
	System.out.println(property);
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext8.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
	  UserDao userDAO = (UserDao) context.getBean("userDao");
      // 调用 UserDAO 的方法
      User user = userDAO.findUserById("Jack");
      // 输出用户信息
      System.out.println(user.getPassword() + ":" + user.getUsername());
}
}
