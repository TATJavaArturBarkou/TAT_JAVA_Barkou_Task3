package by.epam.barkou.controller.util;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;

public class AccessLevelChecker {

	private static final int FIRST_USER = 0;

	public static boolean checkAccessLevel(Command executionCommand) {
		int guestAccess = 0;
		if (executionCommand.getAccessLevel() > guestAccess) {

			return checkAuthorization(executionCommand);

		} else {
			return true;

		}

	}

	public static boolean checkAuthorization(Command executionCommand) {

		if (!Controller.authorized_users.isEmpty()) {
			if (Controller.authorized_users.get(FIRST_USER).getRole() >= executionCommand.getAccessLevel()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean checkUserIsYouAre(User user) {
		return Controller.authorized_users.get(FIRST_USER).getEmail().equals(user.getEmail());
	}

}
