package amazon;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThresoldCount {
  public static void main(String[] args) {
    String[] logs = new String[]{"9 7 50", "22 7 20", "33 7 50", "22 7 30"};
    List logData = Arrays.asList(logs);
    processLogs(logData, 2);

  }


  public static List<String> processLogs(List<String> logs, int threshold) {
    // Write your code here
    System.out.println(logs);
    Map<Integer, Integer> counter = new HashMap<Integer, Integer>();


    for (int i = 0; i < logs.size(); i++) {
      System.out.println(logs.get(i));
      int[] transaction = Arrays.stream(logs.get(i).split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(logs.get(i) + ":" + transaction.length);
      if (transaction[0] != transaction[1]) {
        update_result(counter, transaction[0]);
        update_result(counter, transaction[1]);
      }
      else
        update_result(counter, transaction[0]);
    }
    counter.entrySet().forEach(entry -> {
      System.out.println(entry.getKey() + " " + entry.getValue());
    });

    List output=counter.entrySet().stream()
      .filter(entry -> entry.getValue() >= threshold)
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());
    output.sort(Comparator.naturalOrder());
    System.out.println(output);
    List<String> newList =  transform(output, String::valueOf);
    return newList;
  }

  public static void update_result(Map<Integer, Integer> counter, Integer key) {
    if (counter.containsKey(key))
      counter.put(key, counter.get(key) + 1);
    else
      counter.put(key, 1);
  }

  public static <T, U> List<U> transform(List<T> list,
                                         Function<T, U> function)
  {
    return list.stream()
      .map(function)
      .collect(Collectors.toList());
  }
}
