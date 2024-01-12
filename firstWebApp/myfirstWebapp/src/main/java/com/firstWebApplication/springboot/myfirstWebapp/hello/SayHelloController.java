package com.firstWebApplication.springboot.myfirstWebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	// url : "say-hello" => return : "Hello, what are you learning today?"

	@RequestMapping("/say-hello")
	@ResponseBody
	public String retriveString() {
		String str = "hello, what are you learning today?";
		return str;
	}

	@RequestMapping("/say-hello-html")
	@ResponseBody
	public StringBuilder retriveStringHTML() {
		StringBuilder stringbuilder = new StringBuilder();

		stringbuilder.append("<html>\n" + "	<head>\n" + "	<title>My first HTML Page</title>\n" + "	</head>");
		stringbuilder.append("	<body>\n" + "	My first HTML page with body\n" + "	</body>\n" + "</html>");
		return stringbuilder;
	}

	// "sayHelloJSP method" -> sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
	@RequestMapping("/say-hello-jsp")
	public String sayHelloJSP() {
		String str = "sayHello";
		return str;
	}
}
