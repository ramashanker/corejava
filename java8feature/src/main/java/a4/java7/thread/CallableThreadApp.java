package a4.java7.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
 * https://www.youtube.com/watch?v=ImtZgX1nmr8
 */
public class CallableThreadApp {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);
		Future<Integer> future = service.submit(new Task());

		int result;
		try {
			/*
			 * blocking the main thread this. This will become even worse if suppose we have
			 * used for loop to submit 5 task.if task 4th is completed and task 2 is not
			 * completed the task 4 will wait unitill task 2 and 3 is not completed 
			 * 
			 */
			result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		/*
		 * Another problem is difficult to scale up the application see below example.
		 * Suppose we have online order app which have multiple task as 
		 * MakeOrderTask(Order)--->AcceptOrderTask(Order)->
		 */

	}

	static class Task implements Callable<Integer> {

		@Override
		public Integer call() throws Exception {

			return new Random().nextInt(10);
		}

	}
}
