package com.test.buro.utils;

import org.jasypt.util.text.BasicTextEncryptor;

public class Utileria {
	
	private static char[] password = "secret".toCharArray();

	public static  String getResult(String num1, String num2, String operacion) {
		String result = null;
		
		switch(operacion) {
			case "suma":
				int rs = Integer.valueOf(num1) + Integer.valueOf(num2);
				result =  String.valueOf(rs);
				break;
			case "resta":
				int rr = Integer.valueOf(num1) - Integer.valueOf(num2);
				result =  String.valueOf(rr);
				break;
			case "multiplicacion":
				int rm = Integer.valueOf(num1) * Integer.valueOf(num2);
				result =  String.valueOf(rm);
				break;
			case "division":
				int rd = Integer.valueOf(num1) / Integer.valueOf(num2);
				result =  String.valueOf(rd);
				break;
		}
		
		return result;
	}
	
	public static String encrypt(String input)  {
		
		 BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	        textEncryptor.setPasswordCharArray(password);
	        String encryptedText = textEncryptor.encrypt(input);

	        return encryptedText;
		}
	
	public static String decrypt(String inptu){
		
		
		 BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
	        textEncryptor.setPasswordCharArray(password);
	        String decryptedText = textEncryptor.decrypt(inptu);

	        return decryptedText;
		}

}
