package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {

		var context =

				new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class);

		System.out.println(context.getBean(BusinessCalculationService.class).findMax());

	}

}
