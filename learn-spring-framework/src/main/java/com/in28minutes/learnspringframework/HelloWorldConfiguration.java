package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {
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
		return (new Person("hyunji", 20, new Address("main Street", "London")));

	}

	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address()); // name, age, address()

	}

	@Bean
	public Person person3Parameters(String name, int age, Address address3) { // name, age, address2
		return new Person(name, age, address3);

	}

	@Bean(name = "address2")
	public Address address() {
		var address = new Address("firstline", "Seoul");

		return (address);
	}

	@Bean(name = "address3")
	public Address address3() {
		return (new Address("Moti", "Paris"));
	}

}
