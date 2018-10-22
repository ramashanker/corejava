package a4.java8.thread.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallableLambda {
	public static void main(String[] args) throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(2);
		FutureTask<String>[] futureTask = new FutureTask[5];
		String result = "result data";
		Callable<String> callable = () -> {
			return result.concat(":Mycallable");
		};
		for (int i = 0; i < 3; i++) {
			futureTask[i] = (FutureTask<String>) service.submit(callable);
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(futureTask[i].get());
		}
		service.shutdown();
	}
}
