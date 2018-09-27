package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {
	
	
	@Pointcut("execution(* com.example.demo.controller.*.**(..))")
	public void testPoint() {}
	
	
	@Around(value="testPoint()")
	public Object testAround(ProceedingJoinPoint joinPoint) {
		
		Object obj = null;
		try {
			System.out.println("begin joinPoint");
			obj =  joinPoint.proceed();
			System.out.println("end joinPoint");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}

}
