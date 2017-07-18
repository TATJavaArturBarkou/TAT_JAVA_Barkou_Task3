package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.controller.util.RequestChecker;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class AddBook extends Command {

	private final int accessLevel = 2;
	private final int bookName = 1;
	private final int bookAvailability = 2;
	private String response = null;

	@Override
	public String execute(Request requestObj) {

		String[] requestData = requestObj.getCommandWithParams().split(SPLITTER);

		int paramsQuantity = 1;
		if (RequestChecker.checkParams(requestData, paramsQuantity)) {

			Book book = new Book(requestData[bookName], requestData[bookAvailability]);
			ServiceFactory factory = ServiceFactory.getInstance();
			ILibraryService libraryService = factory.getLibraryService();

			try {

				libraryService.addNewBook(book);
				response = "Book has been added successfully";

			} catch (ServiceException e) {
				response = "Unable to add book";
				System.out.println("log: " + e.getMessage());

			}

		} else {
			response = "Not able to perform operation, you haven't specified necessary parameters";
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
