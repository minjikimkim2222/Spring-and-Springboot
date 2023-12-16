package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {

	private ClassA classA;

	public ClassB(ClassA classA) { // 의존성 정의 - ClassB가 ClassA에 의존

		System.out.println("Some initialization logic");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("do something");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {

		var context =

				new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class);

		System.out.println("Intialization of context is complected");

		context.getBean(ClassB.class).doSomething();

	}

}
