package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		try (// 1 : Launch a Spring Context
				var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			// 3 : Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));

			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("address2")); // Bean 이름을 변경한 것으로 찾는다
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean("person", Person.class));

			System.out.println("test 구분선");
			System.out.println(context.getBean(Address.class));

//		System.out.println("step 14"); // 함수형 프로그래밍을 이용
//		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // method 참
			System.out.println("test 구분선2");
			System.out.println(context.getBean("person5Qualifier"));

		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
