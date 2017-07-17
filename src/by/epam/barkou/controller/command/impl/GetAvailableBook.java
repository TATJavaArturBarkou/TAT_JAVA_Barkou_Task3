package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class GetAvailableBook extends Command {

	private String response = null;
	
	private final int bookId = 1;

	private final int accessLevel = 1;

	@Override
	public String execute(String request) {

		String[] requestData = request.split(SPLITTER);

		Book book = new Book(requestData[bookId]);
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {

			
			response = libraryService.getAvailableBook(book);
		} catch (ServiceException e) {
			response = "Unable to get book";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {

		return this.accessLevel;
	}

}
