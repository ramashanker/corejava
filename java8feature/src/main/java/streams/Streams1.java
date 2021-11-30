package streams;


// Source----Filter-----Sort-----map-----collect


// Source---Start Operation list stream or any things

//Intermediate operation -Filter(Condirtion)-----Sort-----map(Transform)-
// Example: anyMatch() distinct(),filter(),findFirst(),flatmap(),map()

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Terminal Operation  foreach,Collect,reduce,count,max,min,summaryStatistics
public class Streams1 {
  public static void main(String[] args) throws IOException {
    IntStream data1 = IntStream.range(1, 10);
    data1.forEach(System.out::println);

    System.out.println("Skip first 5 element");

    IntStream data2 = IntStream.range(1, 20);
    data2.skip(5).forEach(x -> System.out.println((x)));


    System.out.println("Sum of element");
    IntStream data3 = IntStream.range(1, 5);
    System.out.println(data3.sum());

    // Stream of String
    System.out.println("Short and print first");
    String[] names = {"gg", "cc", "bb"};
    Stream.of(names).sorted().findFirst().ifPresent(System.out::println);

    System.out.println("Start with ra");
    String[] mynames = {"rama", "rakesh", "shanker"};
    Stream.of(mynames).filter(x -> x.startsWith("ra")).sorted().forEach(System.out::println);


    System.out.println("Square and average the data");
    Arrays.stream(new int[]{1, 2, 3}).map(x -> x * x).average().ifPresent(System.out::println);

    System.out.println("Lower case and start with an");
    String[] caps_name = {"Anki", "Anik", "Aradh", "Ashu"};
    Stream.of(caps_name).map(String::toLowerCase).filter(x -> x.startsWith("an")).forEach(System.out::println);

    System.out.println("Lower case and start with an");
    List<String> cap_name = Arrays.asList("Anki", "Anik", "Aradh", "Ashu");
    cap_name.stream().map(String::toLowerCase).filter(x -> x.startsWith("an")).forEach(System.out::println);

    System.out.println("Read from file for partial");
    Stream<String> result = Files.lines(Paths.get("/home/aa100418/gitrama/corejava/java8feature/src/main/java/streams/result.txt"));
    result.sorted().filter(x -> x.contains("part")).forEach(System.out::println);
    result.close();

    System.out.println("Read from file for success");
    Stream<String> result1 = Files.lines(Paths.get("/home/aa100418/gitrama/corejava/java8feature/src/main/java/streams/result.txt"));
    List<String> filterresult = result1.sorted().filter(x -> x.contains("succ")).collect(Collectors.toList());
    filterresult.forEach((x -> System.out.println(x)));
    result1.close();

    System.out.println("Read from file for each data");
    Stream<String> data_result = Files.lines(Paths.get("/home/aa100418/gitrama/corejava/java8feature/src/main/java/streams/data.txt"));
    data_result.map(x -> x.split(",")).filter(x -> x.length > 3).forEach(x -> System.out.println(x[0] + " : " + x[1] + " : " + x[2] + " : " + x[3]));
    data_result.close();

    System.out.println("filter with greater than 3");
    Stream<String> data_result1 = Files.lines(Paths.get("/home/aa100418/gitrama/corejava/java8feature/src/main/java/streams/data.txt"));
    data_result1.map(x -> x.split(",")).filter(x -> x.length > 3).filter(x -> Integer.parseInt(x[1]) > 3).forEach(x -> System.out.println(x[0] + " : " + x[1] + " : " + x[2] + " : " + x[3]));
    data_result1.close();

    System.out.println("filter with greater than 3 to map");
    Stream<String> data_result2 = Files.lines(Paths.get("/home/aa100418/gitrama/corejava/java8feature/src/main/java/streams/data.txt"));
    Map collect_result = data_result2.map(x -> x.split(",")).filter(x -> x.length > 3).filter(x -> Integer.parseInt(x[1]) > 3).collect(Collectors.toMap(
      x -> x[0],
      x -> Integer.parseInt(x[1])
    ));
    data_result2.close();
    for (Object key : collect_result.keySet()) {
      System.out.println(key + ":::::" + collect_result.get(key));
    }

    // Reduction to sum
    // a is start b is adding up in to a from stream a=0 b=3....a=3 b=4....a=7 b=3
    double total = Stream.of(3, 4, 3, 5, 2).reduce(0, (Integer a, Integer b) -> a + b);

    System.out.println("total:::" + total);

    //Reduction summary statistics only work for integer
    IntSummaryStatistics summary = IntStream.of(2, 3, 4, 5, 6, 7).summaryStatistics();
    System.out.println(summary);


    // map method us for transformation one to one mapping
    // flatmap used for transformation and flattering= map+flattering----one to many mapping

    Stream.of("a", "b", "c", "d").map(x -> x.toUpperCase()).forEach(System.out::println);
    List<Integer> ar1 = new ArrayList<>();
    ar1.add(2);
    ar1.add(3);
    ar1.add(4);
    ar1.add(5);

    List<Integer> ar2 = new ArrayList<>();
    ar2.add(2);
    ar2.add(4);
    ar2.add(3);
    ar2.add(6);

    List<String> a = Arrays.asList("1", "2", "3");
    List<String> b = Arrays.asList("10", "20", "30");

    List<String> c = IntStream.range(0, a.size())
      .map(i -> Integer.parseInt(a.get(i)) - Integer.parseInt(b.get(i))).filter(x->x<0)
      .mapToObj(Integer::toString)
      .collect(Collectors.toList());
    c.forEach(System.out::println);
  }
}
