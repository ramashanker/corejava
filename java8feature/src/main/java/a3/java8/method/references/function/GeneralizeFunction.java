package a3.java8.method.references.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GeneralizeFunction {
	public static void main(String[] args) {
		String result=transform("rama",String::toUpperCase);
		System.out.println(result);
		int data=transform(5,GeneralizeFunction::dataSum);
		System.out.println(data);
		List <String> words= Arrays.asList("a","b","c");
		/*
		 * List has a size method which return int length of array.
		 */
		int size=transform(words,List::size);
		System.out.println(size);
	}

	/*
	 * Here T is a input and R is a output for generalization Function.
	 */
	
	public static <T,R> R transform(T value,Function<T, R> f) {
		return f.apply(value);
	}
	
	public static int dataSum(int x) {
		int sum=0;
		for(int i=0;i<x;i++) {
			sum=sum+i;
		}
		return sum;
	}
}
