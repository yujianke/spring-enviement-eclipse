package com.spring.datasource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service("testAdd")
public class TestAdd {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public void saveadd(){
		   String insertSql = " INSERT INTO user01 (username, password, money) VALUES (?, ?, ?) ";
		    List<Object[]> batchList = new ArrayList<Object[]>();
		    batchList.add(new Object[]{"Jack", "10101010", 100.0});
		    batchList.add(new Object[]{"Lucy", "10101010", 1000.0});
		    batchList.add(new Object[]{"Mary", "10101010", 10000.0});
		    int[] insertRows = jdbcTemplate.batchUpdate(insertSql, batchList);
		    int i=1/0;
		    System.out.println("新增数据：" + insertRows.length + "条");
	}
}
