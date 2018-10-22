package a6.java8.foreach;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
/*
 * Documentation
 * https://dzone.com/articles/devoxx-2012-java-8-lambda-and
 * https://www.journaldev.com/2389/java-8-features-with-examples
 */
public class CollectionsForEach {
	static Logger logger = Logger.getLogger(CollectionsForEach.class.getName());
	public static void main(String[] args) {
		/*
		 * Creating sample collection and populate value
		 */
		List<String> names = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			names.add("name-" + i);
		}

		/*
		 * Iterate over collection to fetch the data
		 */
		Iterator<String> name = names.iterator();
		while (name.hasNext()) {
			logger.info(name.next());
		}

		/*
		 * traversing through forEach method of iterable with anonymous class
		 */
		names.forEach(new Consumer<String>() {
			public void accept(String name) {
				logger.info("Anonymous class foreach Value:" + name);
			}

		});
		
		names.forEach((n)->System.out.println("lambda:"+n));
		
		/*
		 * traversing through consumer interface implementation
		 */
		MyConsumer action= new MyConsumer();
		names.forEach(action);
	}

}
/*
 * helps in having our business logic at a separate location that we can reuse
 */
class MyConsumer implements Consumer<String>{
	static Logger logger = Logger.getLogger(MyConsumer.class.getName());
	public void accept(String myname) {
		logger.info("Myconsumer class foreach Value:" + myname);
	}
	
}
