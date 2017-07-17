package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.security.Encryptor;

import by.epam.barkou.service.IClientService;
import by.epam.barkou.service.exception.ServiceException;
import by.epam.barkou.service.factory.ServiceFactory;

public class UpdateProfile extends Command {

	private final int accessLevel = 1;
	private final int email = 1;
	private final int password = 2;
	private String response = null;
	private final int firstUser = 0;

	@Override
	public String execute(String request) throws ControllerException {
		String[] requestData = request.split(SPLITTER);

		String encryptedPassword = Encryptor.encrypt(requestData[password]);

		String userId = Controller.authorized_users.get(firstUser).getId();

		User user = new User(userId, requestData[email], encryptedPassword);

		try {

			ServiceFactory factory = ServiceFactory.getInstance();
			IClientService clientService = factory.getClientService();

			clientService.updateProfile(user);

			Controller.authorized_users.clear();
			user = clientService.signIn(requestData[email], encryptedPassword);
			Controller.authorized_users.add(user);
			
			response = "User is updated successfully";
		} catch (ServiceException e) {
			response = "Unable to update profile";
			System.out.println("log: " + e.getMessage());
		}

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
