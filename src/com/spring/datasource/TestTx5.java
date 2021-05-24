package com.spring.datasource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TestTx5 {
	public void add() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext7.xml");
		TestTx6 td6 = context.getBean("testTx6", TestTx6.class);
		td6.add();
	}


}
