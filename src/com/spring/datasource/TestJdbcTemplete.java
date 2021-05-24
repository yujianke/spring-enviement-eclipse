package com.spring.datasource;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplete{
	    private static JdbcTemplate jdbcTemplate;
		public static void main1(String[] args) {
			    StringBuilder createSql = new StringBuilder();
			    createSql.append(" CREATE TABLE `user01` ( ");
			    createSql.append("     `username` varchar(20) DEFAULT NULL, ");
			    createSql.append("     `password` varchar(20) DEFAULT NULL, ");
			    createSql.append("     `money` decimal(8,2) DEFAULT NULL ");
			    createSql.append(" ) ENGINE=InnoDB DEFAULT CHARSET=utf8 ");
			    jdbcTemplate.execute(createSql.toString());
		}
		
		
		
		private static  void init() {
			ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext4.xml");
			String[] beanDefinitionNames = app.getBeanDefinitionNames();
			for (String string : beanDefinitionNames) {
				System.out.println(string);
			}
			  jdbcTemplate = app.getBean("jdbcTemplate", JdbcTemplate.class);
		}



		public static void main3(String[] args) {
			    init();
			    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext4.xml");
			    JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");

			    String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
			    Object[] insertObjects = new Object[]{"Jack", "10101010", 100.0};
			    int insertRows = jdbcTemplate.update(insertSql, insertObjects);

			    String updateSql = " UPDATE user01 SET username = ? ";
			    Object[] updateObjects = new Object[]{"Lucy"};
			    int updateRows = jdbcTemplate.update(updateSql, updateObjects);

			    String deleteSql = " DELETE FROM user01 WHERE username = ? ";
			    Object[] deleteObjects = new Object[]{"Lucy"};
			    int deleteRows = jdbcTemplate.update(deleteSql, deleteObjects);

			    System.out.println("新增数据：" + insertRows + "条");
			    System.out.println("修改数据：" + updateRows + "条");
			    System.out.println("删除数据：" + deleteRows + "条");
		}
		
		

		public static void main(String[] args) {
			    init();
			    String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
			    List<Object[]> batchList = new ArrayList<Object[]>();
			    batchList.add(new Object[]{"Jack", "10101010", 100.0});
			    batchList.add(new Object[]{"Lucy", "10101010", 1000.0});
			    batchList.add(new Object[]{"Mary", "10101010", 10000.0});
			    int[] insertRows = jdbcTemplate.batchUpdate(insertSql, batchList);
			    System.out.println("新增数据：" + insertRows.length + "条");
		}

}
