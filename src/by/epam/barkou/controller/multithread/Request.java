package by.epam.barkou.controller.multithread;

public class Request {
	private String sessionId;
	private String commandWithParams;
	
	
	
	public Request(String sessionId, String commandWithParams) {
		this.sessionId = sessionId;
		this.commandWithParams = commandWithParams;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCommandWithParams() {
		return commandWithParams;
	}
	public void setCommandWithParams(String commandWithParams) {
		this.commandWithParams = commandWithParams;
	}


}
