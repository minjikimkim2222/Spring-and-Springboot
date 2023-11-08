package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {
};

record Address(String firstLine, String city) {

};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Minji";
	}

	@Bean
	public int age() {
		return 15;
	}

	@Bean
	public Person person() {
		var person = new Person("hj", 20); // Person record 생성자
//
//		person.age(); // getter 메서드 대신
//		person.name(); // getter 메서드가 자동으로
		return (person);

	}

	@Bean
	public Address address() {
		var address = new Address("firstline", "Seoul");

		return (address);
	}

}
