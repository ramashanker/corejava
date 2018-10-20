package com.rama.java8.method.references;

public class StringUtil {

	public static String transform(String s, StringFunction f) {
		return f.applyFunction(s);
	}

	public static String makeExiting(String s) {
		return (s + "!!");
	}

	private StringUtil() {

	}
}
