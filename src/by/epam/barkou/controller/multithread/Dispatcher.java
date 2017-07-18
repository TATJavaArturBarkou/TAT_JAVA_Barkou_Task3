package by.epam.barkou.controller.multithread;

import java.util.concurrent.Callable;


import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.multithread.util.RequestParser;

public class Dispatcher implements Callable<String> {

	String request;
	
	public Dispatcher(String request){
		this.request = request;
	}
	
	@Override
	public String call() throws Exception {
		
		RequestParser parser = new RequestParser();
		Request requestObj = parser.parseRequest(request);
		
		Controller controller = new Controller();
		String response = controller.executeTask(requestObj);
		return response;
	}

	


}
