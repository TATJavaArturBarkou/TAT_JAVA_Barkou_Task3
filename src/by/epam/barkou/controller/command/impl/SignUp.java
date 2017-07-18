package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.controller.security.Encryptor;
import by.epam.barkou.service.IClientService;

import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class SignUp extends Command {

	private final int accessLevel = 0;
	private final int email = 1;
	private final int password = 2;
	private String response = null;

	@Override
	public String execute(Request requestObj) throws ControllerException {
		String[] requestData = requestObj.getCommandWithParams().split(SPLITTER);

		String encryptedPassword = Encryptor.encrypt(requestData[password]);

		User user = new User(requestData[email], encryptedPassword);

		ServiceFactory factory = ServiceFactory.getInstance();
		IClientService clientService = factory.getClientService();

		try {

			 clientService.signUp(user);
			 response ="User is registred successfully";
		} catch (ServiceException e) {
			response = "Unable to sign up";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
