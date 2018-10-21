package com.rama.java8.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CompltableFuture {
	private final static Logger LOGGER = Logger.getLogger(CompltableFuture.class.getName());
	private static ExecutorService pool = Executors.newFixedThreadPool(10);

	public static Future<String> calculateAsync(String data) throws InterruptedException {
		CompletableFuture<String> completableFuture = new CompletableFuture<>();

		Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(5000);
			completableFuture.complete(data);
			return null;
		});

		return completableFuture;
	}

	/*
	 * Here every time the result return in new Completablefuture which will not
	 * block with existing process
	 */
	public static Future<String> calculateAsyncWithouBlock(String data) throws InterruptedException {
		Thread.sleep(5000);
		return CompletableFuture.completedFuture(data);

	}

	/*
	 * process data and return in future chain
	 */

	public static Future<String> asynchComputationThenApply(String now, String then) throws InterruptedException {
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> now).thenApply(s -> s + then);
		/*
		 * CompletableFuture<String> completableFuture =
		 * CompletableFuture.supplyAsync(() -> now);
		 * 
		 * CompletableFuture<String> future = completableFuture .thenApply(s -> s
		 * +then);
		 */

		return completableFuture;

	}

	/*
	 * If you dont need to return the value down the future chain then can use then
	 * accept
	 */

	public static CompletableFuture<Void> asynchComputationWithAccept(String now, String then)
			throws InterruptedException {
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> now)
				.thenAccept(s -> LOGGER.info("Computation returned: " + s + then));
		/*
		 * CompletableFuture<String> completableFuture =
		 * CompletableFuture.supplyAsync(() -> now); CompletableFuture<String> future
		 * =completableFuture .thenAccept(s ->
		 * System.out.println("Computation returned: " + s));
		 */
		return future;

	}

	/*
	 * if you neither need the value of the computation nor want to return some
	 * value at the end of the chain, then you can pass a Runnable lambda to the
	 * thenRun method. In the following example, after the future.get() method is
	 * called, we simply print a line in the console:
	 */

	public static CompletableFuture<Void> asynchComputationWithThenRun(String now, String then)
			throws InterruptedException, ExecutionException {
		/*
		 * CompletableFuture<Void> future = CompletableFuture.supplyAsync(() ->
		 * now+then) .thenRun(() -> System.out.println("Computation returned: "));
		 */

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> now);
		CompletableFuture<Void> future = completableFuture.thenAccept(s -> LOGGER.info("Computation returned: " + s));
		return future;

	}

	/*
	 * Executor service for callback and transformation then apply
	 */

	public static CompletableFuture<String> transformationExecutorService(String string) throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info(Thread.currentThread().getName());
			return string + "Hello";
		}, pool);

		future.thenApply(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":First transformation");
			return s.length();
		});
		future.get();
		pool.shutdownNow();
		pool.awaitTermination(1, TimeUnit.MINUTES);
		future.thenApply(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":Second transformation");
			return s.length();
		});

		return future;

	}

	/*
	 * Executor service for callback and transformation thenApplyAsync which default
	 * will use fork and join executor service
	 */

	public static CompletableFuture<String> transformationExecutorServiceAsynchApply(String string) throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info(Thread.currentThread().getName());
			return string + "Hello";
		}, pool);

		future.thenApply(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":First transformation");
			return s.length();
		});
		future.get();
		pool.shutdownNow();
		pool.awaitTermination(1, TimeUnit.MINUTES);
		future.thenApplyAsync(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":Second transformation");
			return s.length();
		});

		return future;

	}
	
	/*
	 * Executor service for callback and transformation thenApplyAsync which default
	 * will use fork and join executor service
	 */

	public static CompletableFuture<String> transformationExecutorServiceThenApplyAsynchWithOwnThreadpool(String string) throws Exception {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info(Thread.currentThread().getName());
			return string + "Hello";
		}, pool);

		future.thenApply(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":First transformation");
			return s.length();
		});
		future.get();
		pool.shutdownNow();
		pool.awaitTermination(1, TimeUnit.MINUTES);
		ExecutorService pool2 = Executors.newFixedThreadPool(10);
		future.thenApplyAsync(s -> {
			LOGGER.info(Thread.currentThread().getName() + ":Second transformation");
			return s.length();
		},pool2);

		return future;

	}
}
