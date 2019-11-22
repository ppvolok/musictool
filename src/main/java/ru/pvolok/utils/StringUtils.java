package ru.pvolok.utils;

public class StringUtils {

	public static String removeQuotes(String s) {
		return s.replaceAll("\"", "");
	}
}
