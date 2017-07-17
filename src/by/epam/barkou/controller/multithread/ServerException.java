package by.epam.barkou.controller.multithread;

public class ServerException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServerException() {
		super();
	}

	public ServerException(String message) {
		super(message);
	}

	public ServerException(Exception e) {
		super(e);
	}

	public ServerException(String message, Exception e) {
		super(message, e);
	}
}
