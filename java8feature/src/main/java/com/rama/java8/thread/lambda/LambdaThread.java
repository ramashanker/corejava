package com.rama.java8.thread.lambda;

public class LambdaThread {
	public static void main(String[] args) {
       new Thread(()->System.out.println("Lambda thread is running:")).start();
       
       new Thread(System.out::println).start();
       
       new Thread(()->printData()).start();
       
       new Thread(LambdaThread::printData).start();
	}
	private static void printData() {
		for(int i=0;i<10;i++) {
			System.out.println("Index:"+i);
		}
	}
}
