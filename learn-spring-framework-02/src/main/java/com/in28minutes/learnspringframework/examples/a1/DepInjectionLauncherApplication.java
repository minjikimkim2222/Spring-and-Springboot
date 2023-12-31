package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//YourBusinessClass
//Dependency1
//Dependency2
//Dependency1과 Dependency2를 YourBusinessClass에 주입하는 방법을 알아보자.

@Component
class YourBusinessClass {

	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		// System.out.println("Constructor Injection - YourBussinessClass ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}

	public void execute() {
		// YourBusinessClass의 toString 메서드를 통해 의존성 사용
		System.out.println("execute 실행 " + toString());
	}
}

@Component
class Dependency1 {
}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {

		var context =

				new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class);

		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		// 현재 Bean이 무엇이 있는지 출력

		// System.out.println(context.getBean(YourBusinessClass.class));

		// @Autowired를 통해 주입될 YourBusinessClass 객체 사용

		YourBusinessClass application = context.getBean(YourBusinessClass.class);

		application.execute();

	}

}
