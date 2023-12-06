package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	var game = new MarioGame();
		
//	var game = new SuperContraGame();
		var game = new PacmanGame(); // 1. object creation
		var gameRunner = new GameRunner(game);
		// 2 : Object Creation + Wiring of Dependency (의존성을 연결)
		// game is a Dependency of GameRunner 
		gameRunner.run();
	}

}
