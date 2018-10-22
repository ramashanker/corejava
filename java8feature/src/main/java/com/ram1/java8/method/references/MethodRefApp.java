package com.ram1.java8.method.references;

public class MethodRefApp {
	public static void main(String[] args) {
		
		/*
		 * own static method sugar square method reference
		 */
		//ExponentialData result = a -> RefUtil.getExponential(a);
		ExponentialData result = RefUtil::getExponential;
		System.out.println(result.getExponentialdata(3));
		
		/*
		 * Math static method sugar square method reference
		 */
		//ExponentialData result1 = a -> Math.sqrt(a);
		ExponentialData result1 = Math::sqrt;
		System.out.println(result1.getExponentialdata(3));
		
		
		/*
		 * more understanding where to use
		 * 
		 * Interface like in java 7
		 * public interface Foo {double method1(double d);}
		 * public interface Bar {double method2(double d);}
		 * public interface Baz {double method3(double d);}
		 * 
		 * Method that uses interfaces (java 7)
		 * public void blah1(Foo f){.... f.method1(double d)...}
		 * public void blah2(Bar b){.... f.method2(double d)...}
		 * public void blah3(Baz b){.... f.method3(double d)...}
		 * 
		 * Calling The method(use lambda or method references)
		 * 
		 * blah1(Math::sin) or blah1(d->Math.sin(d)
		 * blah1(Math::cos) or blah1(d->Math.cos(d);
		 * blah1(Math::log) or blah1(d->Math.log(d);
		 * 
		 * here Math::sin is a Foo interface context.
		 * 
		 */
		
		
	}
}
