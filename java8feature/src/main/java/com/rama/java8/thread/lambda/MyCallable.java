package com.rama.java8.thread.lambda;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		return "Mycallable is running";
	}

}
