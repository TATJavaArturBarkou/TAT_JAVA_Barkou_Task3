package by.epam.barkou.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.barkou.controller.command.impl.AddAdminRights;
import by.epam.barkou.controller.command.impl.AddBook;
import by.epam.barkou.controller.command.impl.GetAllAvailableBooks;
import by.epam.barkou.controller.command.impl.GetAvailableBook;
import by.epam.barkou.controller.command.impl.GetUser;
import by.epam.barkou.controller.command.impl.OrderBook;
import by.epam.barkou.controller.command.impl.SetUserBanned;
import by.epam.barkou.controller.command.impl.ShowProfile;
import by.epam.barkou.controller.command.impl.SignUp;
import by.epam.barkou.controller.command.impl.SignIn;
import by.epam.barkou.controller.command.impl.SignOut;
import by.epam.barkou.controller.command.impl.UpdateBook;
import by.epam.barkou.controller.command.impl.UpdateProfile;
import by.epam.barkou.controller.command.impl.WrongRequest;

public class CommandProvider {
	private final Map<CommandName, Command> repositiry = new HashMap<CommandName, Command>();

	public CommandProvider() {
		repositiry.put(CommandName.SIGN_IN, new SignIn());
		repositiry.put(CommandName.SIGN_UP, new SignUp());
		repositiry.put(CommandName.ADD_BOOK, new AddBook());
		repositiry.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repositiry.put(CommandName.UPDATE_BOOK, new UpdateBook());
		repositiry.put(CommandName.GET_ALL_AVAILABLE_BOOKS, new GetAllAvailableBooks());
		repositiry.put(CommandName.SHOW_PROFILE, new ShowProfile());
		repositiry.put(CommandName.UPDATE_PROFILE, new UpdateProfile());
		repositiry.put(CommandName.ADD_ADMIN_RIGHTS, new AddAdminRights());
		repositiry.put(CommandName.SET_USER_BANNED, new SetUserBanned());
		repositiry.put(CommandName.ORDER_BOOK, new OrderBook());
		repositiry.put(CommandName.SIGN_OUT, new SignOut());
		repositiry.put(CommandName.GET_AVAILABLE_BOOK, new GetAvailableBook());
		repositiry.put(CommandName.GET_USER, new GetUser());
	}

	public Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;

		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repositiry.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			command = repositiry.get(CommandName.WRONG_REQUEST);
		}

		return command;
	}
}
