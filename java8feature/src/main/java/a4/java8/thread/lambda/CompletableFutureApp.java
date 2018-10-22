package a4.java8.thread.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureApp {
	public static void main(String[] args) throws Exception {
		List<CompletableFuture<String>> completablefutures = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(4);
		for (int i = 0; i <4; i++) {
			completablefutures.add(calculateAsync(i,service));
		}
		/*
		 * Here we are blocking the parallel process to sequential
		 */
		for (int i = 0; i <completablefutures.size(); i++) {
			System.out.println(completablefutures.get(i).get());
		}
		
		service.shutdown();

	}
	
	public static CompletableFuture<String> calculateAsync(int data,ExecutorService service) throws InterruptedException {
	    CompletableFuture<String> completableFuture 
	      = new CompletableFuture<>();
	    service.submit(() -> {
	        Thread.sleep(5000+((data+1)*1000));
	        completableFuture.complete("Hello:"+data);
	        return null;
	    });
	 
	    return completableFuture;
	}

}
