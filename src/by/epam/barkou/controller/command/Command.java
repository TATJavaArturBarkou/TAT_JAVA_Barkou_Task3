package by.epam.barkou.controller.command;

import by.epam.barkou.controller.exception.ControllerException;

public abstract class Command {

	public final static String SPLITTER = "&";
	public abstract int getAccessLevel();

	public abstract String execute(String request) throws ControllerException;
}
