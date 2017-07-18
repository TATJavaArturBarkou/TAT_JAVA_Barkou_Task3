package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class UpdateBook extends Command {

	private String response = null;
	private final int bookId = 1;
	private final int bookName = 2;
	private final int bookAvailability = 3;
	private final int accessLevel = 2;

	@Override
	public String execute(Request requestObj) {

		String[] requestData = requestObj.getCommandWithParams().split(SPLITTER);

		Book book = new Book(requestData[bookId], requestData[bookName], requestData[bookAvailability]);
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();

		try {

			libraryService.updateBook(book);
			response = "Book has been updated successfully";
		} catch (ServiceException e) {
			response = "Unable to update book";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {

		return this.accessLevel;
	}

}
