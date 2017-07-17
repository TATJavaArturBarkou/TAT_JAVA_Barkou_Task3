package by.epam.barkou.controller.multithread.util;

import by.epam.barkou.controller.command.Command;
import by.epam.barkou.controller.multithread.Request;
import by.epam.barkou.controller.multithread.ServerException;

public class RequestParser {

	private static final String SESSION_REGEXP_PATTERN = "^sessionId=\\w+";
	private static final String SESSION_PARAM_DELIMETER = "=";
	private static final String ERROR_SESSION_ID_NOT_SPECIFIED = "SessionId isn't specified";

	private final int stringBegining = 0;
	private final int ampersandSimbolIndex = 1;

	public Request parseRequest(String request) throws ServerException {
		String sessionId;
		String commandWithParams;

		// parse data from response
		int commandsBeginIndex = request.indexOf(Command.SPLITTER) + ampersandSimbolIndex;
		commandWithParams = request.substring(commandsBeginIndex);
		sessionId = request.substring(stringBegining, request.indexOf(Command.SPLITTER));

		if (RegexpHelper.hasMatches(SESSION_REGEXP_PATTERN, sessionId)) {

			sessionId = sessionId.substring(stringBegining, sessionId.indexOf(SESSION_PARAM_DELIMETER));

			Request requestObj = new Request(sessionId, commandWithParams);

			return requestObj;
		} else {
			throw new ServerException(ERROR_SESSION_ID_NOT_SPECIFIED);
		}
	}

}
