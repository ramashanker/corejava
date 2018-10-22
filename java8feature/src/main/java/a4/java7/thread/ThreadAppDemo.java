package a4.java7.thread;

import java.util.concurrent.FutureTask;

public class ThreadAppDemo {
	public static void main(String[] args) throws Exception {
		MyRunnable myrunnable = new MyRunnable();
		Thread thread = new Thread(myrunnable);
		thread.start();
		FutureTask<String>[] futureTask = new FutureTask[5];

		for (int i = 0; i < 5; i++) {
			MyCallable callable = new MyCallable();
			futureTask[i] = new FutureTask<String>(callable);
			Thread callthread = new Thread(futureTask[i]);
			callthread.start();
		}
		for (int i = 0; i < futureTask.length; i++) {
			System.out.println(futureTask[i].get());
		}
	}
}
