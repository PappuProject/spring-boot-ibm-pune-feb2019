package com.demo.spring;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		HrService service=(HrService)ctx.getBean("hrService");
		System.out.println(service.registerEmp(100, "James", "Pune", 45000));
		
		System.out.println(service.getClass().getName());
		
		for(Method m:service.getClass().getMethods()) {
			System.out.println(m.getName());
		}

	}

}
