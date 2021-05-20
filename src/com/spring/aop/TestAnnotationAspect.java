package com.spring.aop;
 
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class TestAnnotationAspect {
 
	@Pointcut("execution(* com.spring.service.*.*(..))")
	private void pointCutMethod() {
	}
 
	//����ǰ��֪ͨ
	@Before("pointCutMethod()")
	public void doBefore() {
		System.out.println("ǰ��֪ͨ");
	}
 
	//��������֪ͨ
	@AfterReturning(pointcut = "pointCutMethod()", returning = "result")
	public void doAfterReturning(String result) {
		System.out.println("����֪ͨ");
		System.out.println("---" + result + "---");
	}
 
	//��������֪ͨ
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
		System.out.println("����֪ͨ");
		System.out.println(e.getMessage());
	}
 
	//��������֪ͨ
	@After("pointCutMethod()")
	public void doAfter() {
		System.out.println("����֪ͨ");
	}
 
	//��������֪ͨ
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("���뷽��---����֪ͨ");
		Object o = pjp.proceed();
		System.out.println("�˳�����---����֪ͨ");
		return o;
	}
}