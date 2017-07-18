package by.epam.barkou.controller.command.impl;

import java.util.ArrayList;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class GetAllAvailableBooks extends Command {

	private String response = null;
	private final int accessLevel = 0;

	@Override
	public String execute(Request requestObj) {
		ArrayList<Book> bookList;
		ServiceFactory factory = ServiceFactory.getInstance();
		ILibraryService libraryService = factory.getLibraryService();
		StringBuilder responseBuilder = new StringBuilder();

		try {

			bookList = libraryService.getAllAvailableBooks();

			for (Book book : bookList) {
				responseBuilder.append(book.getName());
				responseBuilder.append(SPLITTER);
			}
			response = responseBuilder.toString();

		} catch (ServiceException e) {
			response = "Unable to get available books";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
