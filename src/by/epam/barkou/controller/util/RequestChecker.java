package by.epam.barkou.controller.util;

public class RequestChecker {

	public static boolean checkParams(String[] requestData, int paramsQuantity) {

		
		if (requestData.length >= (paramsQuantity + 1)) {
			return true;
		}

		return false;

	}

}
