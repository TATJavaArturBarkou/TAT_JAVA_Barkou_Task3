package by.epam.barkou.controller.command;

import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.multithread.Request;

public abstract class Command {

	public final static String SPLITTER = "&";
	public abstract int getAccessLevel();



	public abstract String execute(Request requestObj) throws ControllerException;

}
