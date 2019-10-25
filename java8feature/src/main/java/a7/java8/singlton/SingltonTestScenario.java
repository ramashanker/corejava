package a7.java8.singlton;

import java.util.logging.Logger;

import org.junit.Test;

public class SingltonTestScenario {
	
	private final Logger logger = Logger.getLogger(SingltonTestScenario.class.getName());
	
	@Test
	public void asynchComputationSimpleSinglton() {
		new Thread(() -> logger.info("SimpleSingleton thread1 object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
		new Thread(() -> logger.info("SimpleSingleton thread2 object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
		new Thread(() -> logger.info("SimpleSingleton thread3 object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
	}
	
	@Test
	public void testSimpleSinglton() {
		SimpleSingleton x = SimpleSingleton.getInstance();
		System.out.println();
		logger.info("SimpleSinglton x object hash code value:" + x.hashCode());
		SimpleSingleton y = SimpleSingleton.getInstance();
		logger.info("SimpleSinglton y object hash code value:" + y.hashCode());
		SimpleSingleton z = SimpleSingleton.getInstance();
		logger.info("SimpleSinglton z object hash code value:" + z.hashCode());
	}
	
	@Test
	public void testNoSinglton() {
		NoSinglton x = NoSinglton.getInstance();
		System.out.println();
		logger.info("NoSinglton x object hash code value:" + x.hashCode());
		SimpleSingleton y = SimpleSingleton.getInstance();
		logger.info("NoSinglton y object hash code value:" + y.hashCode());
		SimpleSingleton z = SimpleSingleton.getInstance();
		logger.info("NoSinglton z object hash code value:" + z.hashCode());
	}
	
	@Test
	public void asynchComputationForEnum() {
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();

	}
	
}
