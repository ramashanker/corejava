package com.ram1.java8.method.references.function;

import java.util.function.Function;

import com.ram1.java8.method.references.StringUtil;

public class FuctionString {
	public static void main(String[] args) {
		String result=transform("Rama", String::toUpperCase);
		System.out.println(result);
		String result1=transform("shanker", StringUtil::makeExiting);
		System.out.println(result1);
		String result2=transform("Rama", FuctionString::FuctionString);
		System.out.println(result2);
	}

	public static String transform(String s,Function<String, String> f) {
		return f.apply(s);
	}
	/*
	 * here always the function should be take string as input and produce string as output
	 * other wise it will not accept as a Function<String, String>
	 */
	public static String FuctionString(String str) {
		return "myfunction:"+str;
	}
}
