package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);

		System.out.println(context.getBean(GamingConsole.class));
		context.getBean(GamingConsole.class).up();

		context.getBean(GameRunner.class).run();
	}

////	var game = new MarioGame();
//		
////	var game = new SuperContraGame();
//		var game = new PacmanGame(); // 1. object creation
//		var gameRunner = new GameRunner(game);
//		// 2 : Object Creation + Wiring of Dependency (의존성을 연결)
//		// game is a Dependency of GameRunner 
//		gameRunner.run();
//	}

}
