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
 * ���ʽ����
 * */
public static void main1(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext5.xml");
	String[] beanDefinitionNames = context.getBeanDefinitionNames();
	for (String string : beanDefinitionNames) {
		System.out.println(string);
	}
    JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
   
    PlatformTransactionManager txManager = context.getBean("transactionManager",PlatformTransactionManager.class);
    
    //����������뼶�𣬴�����Ϊ��
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();  
    def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);  
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  
    //����״̬�࣬ͨ��PlatformTransactionManager��getTransaction���������������ȡ����ȡ����״̬��Spring���ݴ�����Ϊ��������ο�������
    TransactionStatus status = txManager.getTransaction(def);  
    try {  
    	String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
	    List<Object[]> batchList = new ArrayList<Object[]>();
	    batchList.add(new Object[]{"Jack", "10101010", 100.0});
	    batchList.add(new Object[]{"Lucy", "10101010", 1000.0});
	    batchList.add(new Object[]{"Mary", "10101010", 10000.0});
	    int[] insertRows = jdbcTemplate.batchUpdate(insertSql, batchList);
	    int i=1/0;
	    System.out.println("�������ݣ�" + insertRows.length + "��");
        txManager.commit(status);  //�ύstatus�а󶨵�����
    } catch (RuntimeException e) {  
        txManager.rollback(status);  //�ع�
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
    
  //���캯����ʼ��TransactionTemplate
    	 TransactionTemplate template = new TransactionTemplate(txManager);
  	     template.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
  	     template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
  	//��дexecute����ʵ���������
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
  		    System.out.println("�������ݣ�" + insertRows.length + "��");
  		}}
  	   );
}
}
