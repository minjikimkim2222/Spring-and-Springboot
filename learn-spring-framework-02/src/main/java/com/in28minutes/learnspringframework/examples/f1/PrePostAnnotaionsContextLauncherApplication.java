package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PrePostAnnotaionsContextLauncherApplication {

	public static void main(String[] args) {

		var context =

				new AnnotationConfigApplicationContext(PrePostAnnotaionsContextLauncherApplication.class);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		// 현재 Bean이 무엇이 있는지 출력
	}

}
