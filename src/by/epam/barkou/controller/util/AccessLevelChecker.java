package by.epam.barkou.controller.util;

import by.epam.barkou.bean.User;
import by.epam.barkou.controller.Controller;
import by.epam.barkou.controller.command.Command;

public class AccessLevelChecker {

	public static boolean checkAccessLevel(Command executionCommand, String userCurrentSessionId) {
		int guestAccess = 0;
		if (executionCommand.getAccessLevel() > guestAccess) {

			boolean hasRights = hasEnoughRights(executionCommand, userCurrentSessionId);
			
			return hasRights;

		} else {
			return true;

		}

	}

	private static boolean hasEnoughRights(Command executionCommand, String userCurrentSessionId) {

		if (!Controller.authorized_users.isEmpty()) {
			if (Controller.authorized_users.get(userCurrentSessionId).getRole() >= executionCommand.getAccessLevel()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	public static boolean checkUserIsYouAre(User user, String userCurrentSessionId) {
		return Controller.authorized_users.get(userCurrentSessionId).getEmail().equals(user.getEmail());
	}

}
