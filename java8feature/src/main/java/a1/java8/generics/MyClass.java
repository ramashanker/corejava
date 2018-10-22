package a1.java8.generics;

public class MyClass<T, U> {
	T object1;
	U object2;

	public MyClass(T object1, U object2) {
		this.object1 = object1;
		this.object2 = object2;
	}

	public void print() {
		System.out.println(object1);
		System.out.println(object2);
	}
}
