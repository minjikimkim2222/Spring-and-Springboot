package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready!");
	}

	@PostConstruct
	public void initialize() { // 가령, db에서 데이터를 가져와 초기화하려고 할 때
		someDependency.getReady();
	}

	@PreDestroy
	public void cleanup() { // db등이 연결되어 있다면 cleanup으로 종료하려고 할 때
		System.out.println("clean up");

	}
}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("Some logic using SomeDependency");

	}

}

@Configuration
@ComponentScan
public class PrePostAnnotaionsContextLauncherApplication {

	public static void main(String[] args) {

		var context =

				new AnnotationConfigApplicationContext(PrePostAnnotaionsContextLauncherApplication.class);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		// 현재 Bean이 무엇이 있는지 출력

		// System.out.println(context.getBean(SomeClass.class));
	}

}
