package a6.java8.streams;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyMapStream {
	public static void main(String[] args) {
		Map<Integer, String> dataMap = new LinkedHashMap<>();
		insertData(dataMap);
		System.out.println("read before deletion");
		readData(dataMap);
		deleteDataOnCondition(dataMap, 180);
		System.out.println("read after deletion from before 180");
		readData(dataMap);
	}

	private static void insertData(Map<Integer, String> data) {
		data.put(120, "A");
		data.put(140, "B");
		data.put(160, "C");
		data.put(180, "D");
		data.put(190, "E");
		data.put(200, "F");
		data.put(220, "G");
		data.put(240, "H");
		data.put(260, "I");
	}

	private static void readData(Map<Integer, String> dataMap) {
		dataMap.entrySet().forEach(
				entry -> System.out.println("entry Key:" + entry.getKey() + "entry value:" + entry.getValue()));
		/*System.out.println("With Parallel Stream");
		dataMap.entrySet().parallelStream().forEach(
				entry -> System.out.println("entry Key:" + entry.getKey() + "entry value:" + entry.getValue()));*/
	}

	private static void deleteDataOnCondition(Map<Integer, String> dataMap, int index) {
	//	dataMap.entrySet().removeIf(entry-> entry.getKey()<index);
		dataMap.entrySet().removeIf(entry-> entry.getKey().compareTo(Integer.valueOf(index))<=0);
	}

}
