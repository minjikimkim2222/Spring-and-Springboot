package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return (game);
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
//		var gameRunner = new GameRunner(game());
		var gameRunner = new GameRunner(game);
		return (gameRunner);
	}

////	var game = new MarioGame();
//	
////	var game = new SuperContraGame();
//		var game = new PacmanGame(); // 1. object creation
//		var gameRunner = new GameRunner(game);
//		// 2 : Object Creation + Wiring of Dependency (의존성을 연결)
//		// game is a Dependency of GameRunner 
//		gameRunner.run();
}
