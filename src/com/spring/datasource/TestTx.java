package com.spring.datasource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
public class TestTx {
/**
 * 编程式事务
 * */
public static void main1(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
   
    PlatformTransactionManager txManager = context.getBean("transactionManager",PlatformTransactionManager.class);
    
    //定义事务隔离级别，传播行为，
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();  
    def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);  
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  
    //事务状态类，通过PlatformTransactionManager的getTransaction方法根据事务定义获取；获取事务状态后，Spring根据传播行为来决定如何开启事务
    TransactionStatus status = txManager.getTransaction(def);  
    try {  
    	String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
	    List<Object[]> batchList = new ArrayList<Object[]>();
	    batchList.add(new Object[]{"Jack", "10101010", 100.0});
	    batchList.add(new Object[]{"Lucy", "10101010", 1000.0});
	    batchList.add(new Object[]{"Mary", "10101010", 10000.0});
	    int[] insertRows = jdbcTemplate.batchUpdate(insertSql, batchList);
	    int i=1/0;
	    System.out.println("新增数据：" + insertRows.length + "条");
        txManager.commit(status);  //提交status中绑定的事务
    } catch (RuntimeException e) {  
        txManager.rollback(status);  //回滚
    }  
}





public static void main(String[] args) { 	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
   
    PlatformTransactionManager txManager = context.getBean("transactionManager",PlatformTransactionManager.class);
    
  //构造函数初始化TransactionTemplate
    	 TransactionTemplate template = new TransactionTemplate(txManager);
  	     template.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
  	     template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
  	//重写execute方法实现事务管理
  	     template.execute(new TransactionCallbackWithoutResult() {
  		@Override
  		protected void doInTransactionWithoutResult(TransactionStatus status) {
  			String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
  		    List<Object[]> batchList = new ArrayList<Object[]>();
  		    batchList.add(new Object[]{"Jack", "10101010", 100.0});
  		    batchList.add(new Object[]{"Lucy", "10101010", 1000.0});
  		    batchList.add(new Object[]{"Mary", "10101010", 10000.0});
  		    int[] insertRows = jdbcTemplate.batchUpdate(insertSql, batchList);
  		    int i=1/0;
  		    System.out.println("新增数据：" + insertRows.length + "条");
  		}}
  	   );
}
}
