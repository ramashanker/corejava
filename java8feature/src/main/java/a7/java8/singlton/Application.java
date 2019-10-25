package a7.java8.singlton;

import java.util.logging.Logger;

public class Application {
	private final Logger logger = Logger.getLogger(Application.class.getName());

	public static void main(String[] args) {
		Application application = new Application();	
		application.testSimpleSingltonWithThread();
		application.testSimpleSinglton();
		application.testNoSinglton();
		application.testEnumSingltonWithThread();

	}

	private void testNoSinglton() {
		NoSinglton x = NoSinglton.getInstance();
		System.out.println();
		logger.info("NoSinglton x object hash code value:" + x.hashCode());
		SimpleSingleton y = SimpleSingleton.getInstance();
		logger.info("NoSinglton y object hash code value:" + y.hashCode());
		SimpleSingleton z = SimpleSingleton.getInstance();
		logger.info("NoSinglton z object hash code value:" + z.hashCode());
	}

	private void testSimpleSinglton() {
		SimpleSingleton x = SimpleSingleton.getInstance();
		System.out.println();
		logger.info("SimpleSinglton x object hash code value:" + x.hashCode());
		SimpleSingleton y = SimpleSingleton.getInstance();
		logger.info("SimpleSinglton y object hash code value:" + y.hashCode());
		SimpleSingleton z = SimpleSingleton.getInstance();
		logger.info("SimpleSinglton z object hash code value:" + z.hashCode());
	}

	private void testSimpleSingltonWithThread() {
		asynchComputationSimple();
	}

	private void asynchComputationSimple() {
		new Thread(() -> logger.info("SimpleSingleton thread object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
		new Thread(() -> logger.info("SimpleSingleton thread object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
		new Thread(() -> logger.info("SimpleSingleton thread object hash code value: " + SimpleSingleton.getInstance().hashCode())).start();
	}

	private void testEnumSingltonWithThread() {
		asynchComputationForEnum();
	}

	private void asynchComputationForEnum() {
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();
		new Thread(() -> logger.info("EnumSinglton object hash code value: " + EnumSinglton.INSTANCE.hashCode())).start();

	}

}
