package com.ram.java8.lambda;

public class SquarerootApp {
public static void main(String[] args) {
	SquareRoot sqrt=new SquareRoot() {
		@Override
		public double findSquareRoot(int value) {
			return Math.sqrt(value);
		}
	};
	System.out.println(sqrt.findSquareRoot(9));
	
	SquareRoot sqrt1=(value)->Math.sqrt(value);
	System.out.println(sqrt1.findSquareRoot(25));
	
	SumInterface sum1=(a,b)->{
	return a+b;
	};
	System.out.println(sum1.sum(1, 3));
}
}
