package com.onlinefoodorder.util;

public class EncryptDecrypt {
		private String pass;
		private char[] passChar;
		private char[] let;
		private String encryptedPassword;
		EncryptDecrypt(){
			pass = "oracle";
			passChar = pass.toCharArray();
			let = new char[passChar.length];
			int i = 0;
			for(char c : passChar) {
				c+=3;
				let[i] = c;
				i++;
			}
			encryptedPassword = String.valueOf(let);
		}
		public String decrypt() {
			passChar = encryptedPassword.toCharArray();
			let = new char[passChar.length];
			int i = 0;
			for(char c : passChar) {
				c-=5;
				let[i] = c;
				i++;
			}
			return String.valueOf(let);	
		}
}
