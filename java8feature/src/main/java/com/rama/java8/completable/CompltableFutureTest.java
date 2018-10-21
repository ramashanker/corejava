package com.rama.java8.completable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;

public class CompltableFutureTest {

	/*
	 * We simply call the method, receive the Future instance and call the get method on it when we’re ready to block for the result.
	 * notice that the get method throws some checked exceptions, namely ExecutionException (encapsulating an exception that occurred during a computation) 
	 * and InterruptedException (an exception signifying that a thread executing a method was interrupted):
	 */
	@Test
	public void TestcalculateAsyncWithblock() throws ExecutionException {
		try {
			String expected="expected";
			Future<String> completableFuture = CompltableFuture.calculateAsync(expected);
			String actual = completableFuture.get();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 * If you already know the result of a computation, 
	 * you can use the static completedFuture method with an argument that represents a result of this computation. 
	 */
	
	@Test
	public void TestcalculateAsyncWithoutBlock() throws ExecutionException {
		try {
			String expected="expected";
			Future<String> completableFuture = CompltableFuture.calculateAsyncWithouBlock(expected);
			String actual = completableFuture.get();
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestcalculateAsyncComputationThenApply() throws ExecutionException {
		try {
			String now="Hello!!";
			String then="Rama";
			String expected=now+then;
			Future<String> completableFuture = CompltableFuture.asynchComputationThenApply(now, then);
			String actual = completableFuture.get();
			System.out.println(actual);
			assertEquals(expected, actual);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void TestcalculateAsyncComputationThenAccept() throws ExecutionException {
		try {
			String now="Hello!!";
			String then="Rama";
			CompletableFuture<Void> completableFuture = CompltableFuture.asynchComputationWithAccept(now,then);
			assertNull(completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TestcalculateAsyncComputationThenRun() throws ExecutionException {
		try {
			String now="Hello!!";
			String then="Rama";
			CompletableFuture<Void> completableFuture = CompltableFuture.asynchComputationWithThenRun(now,then);
			assertNull(completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void TestransformationExecutorService() throws Exception {
		try {
			String data="Rama";
			String expected=data+"Hello";
			CompletableFuture<String> completableFuture = CompltableFuture.transformationExecutorService(data);
			assertEquals(expected, completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void TesttransformationExecutorServiceAsynchApply() throws Exception {
		try {
			String data="Rama";
			String expected=data+"Hello";
			CompletableFuture<String> completableFuture = CompltableFuture.transformationExecutorServiceAsynchApply(data);
			assertEquals(expected, completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void TesttransformationExecutorServiceThenApplyAsynchWithOwnThreadpool() throws Exception {
		try {
			String data="Rama";
			String expected=data+"Hello";
			CompletableFuture<String> completableFuture = CompltableFuture.transformationExecutorServiceThenApplyAsynchWithOwnThreadpool(data);
			assertEquals(expected, completableFuture.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
