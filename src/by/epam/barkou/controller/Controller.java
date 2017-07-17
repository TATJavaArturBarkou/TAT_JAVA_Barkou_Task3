package by.epam.barkou.controller;

import java.util.ArrayList;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.command.CommandProvider;
import by.epam.barkou.controller.exception.ControllerException;
import by.epam.barkou.controller.util.AccessLevelChecker;

public class Controller {

	private final char paramDelimert = '&';
	private final CommandProvider provider = new CommandProvider();
	public static ArrayList<User> authorized_users = new ArrayList<User>();

	public String executeTask(String request) {

		String command;
		int beginIndex = 0;
		command = request.substring(beginIndex, request.indexOf(paramDelimert));

		String response = null;

		Command executionCommand = provider.getCommand(command);

		try {

			if (AccessLevelChecker.checkAccessLevel(executionCommand)) {
				response = executionCommand.execute(request);
			} else {
				response = "You have no rights to perform this operation";
			}

		} catch (ControllerException e) {
			System.out.println(e.getMessage());
		}

		return response;

	}
}