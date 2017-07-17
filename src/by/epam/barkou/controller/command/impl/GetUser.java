package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class GetUser extends Command {
	private User user;
	private final int accessLevel = 2;
	private final int id = 1;
	private String response = null;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			user = clientService.getUser(requestData[id]);

			response = user.getEmail();

		} catch (ServiceException e) {
			response = "Unable to get user";
			System.out.println("log: " + e.getMessage());
		}
		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
