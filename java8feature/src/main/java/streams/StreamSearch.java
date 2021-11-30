package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSearch {

  public static void main(String[] args) {
    List<String> data= Arrays.asList("Rama","Radha","Rajesh","Raman","Ramaji","Rana","Rishi");
    List<String> result = data.stream()
      .filter(x -> x.contains("Ra")).collect(Collectors.toList());
    }
  }

