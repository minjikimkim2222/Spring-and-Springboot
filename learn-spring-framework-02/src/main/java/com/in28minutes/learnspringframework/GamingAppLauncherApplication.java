package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);

		System.out.println(context.getBean(GamingConsole.class));
		context.getBean(GamingConsole.class).up();

		context.getBean(GameRunner.class).run();
	}

}
