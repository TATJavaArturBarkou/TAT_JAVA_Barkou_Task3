package by.epam.barkou.controller;

import java.util.concurrent.ConcurrentHashMap;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.command.CommandProvider;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.controller.util.AccessLevelChecker;

public class Controller {

	private final char paramDelimert = '&';
	private final CommandProvider provider = new CommandProvider();
	public static ConcurrentHashMap<String, User> authorized_users = new ConcurrentHashMap<String, User>();

	public String executeTask(Request requestObj) {

		String command;
		int beginCommandIndex = 0;
		int endCommandIndex = requestObj.getCommandWithParams().indexOf(paramDelimert);
		String userCurrentSessionId = requestObj.getSessionId();
		
		command = requestObj.getCommandWithParams().substring(beginCommandIndex, endCommandIndex);

		String response = null;

		Command executionCommand = provider.getCommand(command);

		if (AccessLevelChecker.checkAccessLevel(executionCommand, userCurrentSessionId)) {
			try {
				response = executionCommand.execute(requestObj);
			} catch (ControllerException e) {
				e.printStackTrace();
			}
		} else {
			response = "You have no rights to perform this operation";
		}

		return response;

	}
}