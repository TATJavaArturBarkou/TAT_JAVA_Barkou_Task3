package by.epam.barkou.main;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.controller.multithread.ServerException;
import by.epam.barkou.controller.multithread.util.RequestParser;

public class Main {

	public static void main(String[] rgs) {

		
		Request signInRequestObj = new Request("sessionId=3b5hyk1&", "sign_in&admin@gmail.com&admin");
		Request addBookRequestObj = new Request("sessionId=3b5hyk1&", "add_book&Alice in Wonderland&1");
	
		
		
		Controller controller = new Controller();
		System.out.println(controller.executeTask(signInRequestObj));
		
		
		System.out.println(controller.executeTask(addBookRequestObj));

		
		
	}

}
