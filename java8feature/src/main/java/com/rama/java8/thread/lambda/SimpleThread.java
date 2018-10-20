package com.rama.java8.thread.lambda;

public class SimpleThread implements Runnable{

	@Override
	public void run() {
		System.out.println("SinpmeThread is running");
		
	}
	public static void main(String[] args) {
		SimpleThread runnable=new SimpleThread();
		Thread thread=new Thread(runnable);
		thread.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("annonymus thread is running:");
				
			}
		}).start();;
	}

}
