package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;


public class ShowProfile extends Command {
	private User user;
	private final int accessLevel = 1;
	private final int firstUser = 0;

	@Override
	public String execute(String request) throws ControllerException {

		user = Controller.authorized_users.get(firstUser);
		return user.getEmail();

	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}


}
