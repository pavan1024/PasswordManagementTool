package com.epam.pmt.business;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public static boolean isValidPassword(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public static boolean isValidURL(String url) {
		try {
			new URL(url).toURI();
			return true;

		} catch (MalformedURLException | URISyntaxException e) {
			return false;
		}
	}
}
