package by.epam.barkou.controller.command.impl;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;

public class WrongRequest extends Command {

	private final int accessLevel = 0;

	@Override
	public String execute(Request requestObj) {
		return null;
	}

	@Override
	public int getAccessLevel() {
		return this.accessLevel;
	}

}
