package by.epam.barkou.controller.command.impl;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.multithread.Request;


public class ShowProfile extends Command {
	private User user;
	private final int accessLevel = 1;

	@Override
	public String execute(Request requestObj) throws ControllerException {

		user = Controller.authorized_users.get(requestObj.getSessionId());
		return user.getEmail();

	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}


}
