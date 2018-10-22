package com.ram1.java8.method.references;

/*
 * This is a functional interface which has a abstract method which take string as a input and produce string as a output.
 * so any method with any different name support this signature will be accepted by the parameter as a interface.
 * See in StringUtil and StringApp class.
 */
@FunctionalInterface
public interface StringFunction {
	String applyFunction(String str);

}
