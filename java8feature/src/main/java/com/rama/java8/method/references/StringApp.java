package com.rama.java8.method.references;

public class StringApp {
	public static void main(String[] args) {
		String s = "Shanker";
		/*
		 * SomaClass::staticMethod
		 */
		
		String result=StringUtil.transform(s, StringUtil::makeExiting);
		System.out.println(result);
		
		/*
		 * someobject::instanceMethod
		 */
		
		String prefix="Rama";
		String concat=StringUtil.transform(s, prefix::concat);
		System.out.println(concat);
		
		/*
		 * SomeCalss::instanceMethod
		 */
		
        String upper=StringUtil.transform(s, String::toUpperCase);
		
		System.out.println(upper);
		
	}
}
