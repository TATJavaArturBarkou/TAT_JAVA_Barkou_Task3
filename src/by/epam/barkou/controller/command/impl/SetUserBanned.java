package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SetUserBanned extends Command {

	private final int accessLevel = 2;
	private final int userId = 1;
	private final int bannedValue = 2;
	private String response = null;
	private User user;

	@Override
	public String execute(Request requestObj) throws ControllerException {
		String[] requestData = requestObj.getCommandWithParams().split(SPLITTER);
		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();
		try {

			user = clientService.getUser(requestData[userId]);

			if (user != null) {
				clientService.setUserBanned(requestData[userId], requestData[bannedValue]);

				response = "User is updated successfully";
			} else {
				response = "User isn't exists";
			}

		} catch (ServiceException e) {
			response = "Unable ban/unban user";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
