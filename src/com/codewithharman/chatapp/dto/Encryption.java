package com.codewithharman.chatapp.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {

	public static String passwordEncryption(String plainPassword) throws NoSuchAlgorithmException {
		String encryptedPassword = null;
		// MessageDigest Prebult class will change the password
		var messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes()); // it change the plain password to bytes
		byte[] encrypt = messageDigest.digest();

		StringBuffer sb = new StringBuffer();
		for (byte b : encrypt) {

			sb.append(b);
		}
		encryptedPassword = sb.toString();
		return encryptedPassword;
	}

}
