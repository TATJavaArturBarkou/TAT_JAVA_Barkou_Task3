package by.epam.barkou.controller.multithread;

import java.util.concurrent.Callable;


import by.epam.barkou.controller.Controller;

public class Dispatcher implements Callable<String> {

	String request;
	
	public Dispatcher(String request){
		this.request = request;
	}
	
	@Override
	public String call() throws Exception {
		Controller controller = new Controller();
		String response = controller.executeTask(request);
		return response;
	}

	


}
