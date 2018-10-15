package com.rama.java8.lambda;

import java.util.logging.Logger;

public class Application {
	private final static Logger log = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		/*
		 * Implementation of interface to get value
		 */
		SquareRootImpl sqrt = new SquareRootImpl();
		log.info("Implement Result=" + sqrt.findSquareRoot(400));

		/*
		 * Using Annonymous class
		 */

		SquareRoot annonymousRoot = new SquareRoot() {
			@Override
			public double findSquareRoot(int value) {
				return Math.sqrt(value);
			}
		};

		log.info("Annonymous Result=" + annonymousRoot.findSquareRoot(16));

		/*
		 * Implement using lambda
		 */

		SquareRoot lambdaRoot = (n) -> (Math.sqrt(n));

		log.info("Lambda Result=" + lambdaRoot.findSquareRoot(25));

		/*
		 * Lambda Block
		 */
		SquareRoot lambdaBloockRoot = (n) -> {
			double result = (Math.sqrt(n));
			return result;
		};
		log.info("Lambda Block Result=" + lambdaBloockRoot.findSquareRoot(30));
		
		/*
		 * lambda with two input
		 */
		
		Calculator calc= (a,b)->a+b;
		Calculator calc1= (a,b)->a-b;
		log.info("Sum result:"+calc.sum(5, 23));
		log.info("Sum result:"+calc1.sum(23, 5));

	}
	
	
}