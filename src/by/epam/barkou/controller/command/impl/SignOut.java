package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;

public class SignOut extends Command {


	private final int accessLevel = 1;

	private String response = null;

	@Override
	public String execute(String request) throws ControllerException {
	
				Controller.authorized_users.clear();
				response = "User has been signed out";

		return response;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}



}
