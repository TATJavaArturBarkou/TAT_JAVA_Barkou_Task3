package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.Book;
import by.epam.barkou.bean.Order;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.service.ILibraryService;
import by.epam.barkou.service.IOrderService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class OrderBook extends Command {

	private final int accessLevel = 1;
	private final int bookId = 1;

	private final int firstUser = 0;
	private String response = null;

	@Override
	public String execute(Request requestObj) {

		String[] requestData = requestObj.getCommandWithParams().split(SPLITTER);
		ServiceFactory factory = ServiceFactory.getInstance();

		try {
			ILibraryService iLibraryService = factory.getLibraryService();
			Book book = new Book(requestData[bookId]);
			Object object = iLibraryService.getAvailableBook(book);

			if (object != null) {
				String userId = Controller.authorized_users.get(requestObj.getSessionId()).getId();
				Order order = new Order(userId, requestData[bookId]);
				IOrderService iOrderService = factory.getIOrderService();

				iOrderService.orderBook(order);
				response = "Book has been ordered";

			} else {
				response = "Book not exists";
			}

		} catch (ServiceException e) {
			response = "Unable to order book";
			System.out.println("log: " + e.getMessage());
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
