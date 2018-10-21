package com.rama.java8.method.references;

public class StringUtil {
	/*
	 * Here this method accept signature as StringFiction interface in parameter so
	 * any methods which support the applyFuction method signature will accepted as a
	 * StringFunction interface input .See in StringApp
	 */
	public static String transform(String s, StringFunction f) {
		return f.applyFunction(s);
	}

	public static String makeExiting(String s) {
		return (s + "!!");
	}

	private StringUtil() {

	}
}
