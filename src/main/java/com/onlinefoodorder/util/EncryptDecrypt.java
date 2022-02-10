package com.onlinefoodorder.util;

public class EncryptDecrypt {
	private String pass;
	private char[] passChars;
	private char[] let;
	private String encryptedPassword;

	EncryptDecrypt() {
		pass = "oracle";
		passChars = pass.toCharArray();
		let = new char[passChars.length];

		int i = 0;
		for (char c : passChars) {
			c += 8;
			let[i] = c;
			i++;
		}
		encryptedPassword = String.valueOf(let);

	}

	public String decrypt() {

		passChars = encryptedPassword.toCharArray();
		let = new char[passChars.length];
		int i = 0;
		for (char c : passChars) {
			c -= 8;
			let[i] = c;
			i++;
		}
		return String.valueOf(let);
	}


}
