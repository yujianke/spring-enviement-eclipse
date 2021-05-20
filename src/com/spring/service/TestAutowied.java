package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestAutowied {
	@Autowired
	TestAutowied2 t2;
	
	public void testauto(){
		System.out.println("====================");
		t2.testauto2();
	}

}
