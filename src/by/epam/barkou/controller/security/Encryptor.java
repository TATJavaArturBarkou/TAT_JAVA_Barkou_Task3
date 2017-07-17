package by.epam.barkou.controller.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import by.epam.barkou.controller.exception.ControllerException;

public class Encryptor {

	public static String encrypt(String passwordToHash) throws ControllerException {

		String generatedPassword = null;
		String enctyptorType = "MD5";
		int beginIndex = 1;
		int radix = 16;
		int bitwiseValue = 0xff;
		int additiveValue = 0x100;
		try {

			MessageDigest md = MessageDigest.getInstance(enctyptorType);

			md.update(passwordToHash.getBytes());

			byte[] bytes = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(
						Integer.toString((bytes[i] & bitwiseValue) + additiveValue, radix).substring(beginIndex));
			}

			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new ControllerException(e.getMessage());
		}
		return generatedPassword;
	}
}