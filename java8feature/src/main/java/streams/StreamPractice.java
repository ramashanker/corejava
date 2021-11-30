package streams;


import java.util.Arrays;

public class StreamPractice {
  public static void main(String[] args) {
    int[] numbers = new int[1000]; // generate a new int[]

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = i + 1; // generate a random number
    }

    printStreamData(numbers);
    printData(numbers);
   // manupulateData(numbers);
    //manupulateStreamData(numbers);
  }

  private static void printData(int[] data) {
    long starttime = System.currentTimeMillis();
    for (int i = 0; i < data.length; i++) {
      System.out.print(data[i]); // generate a random number
    }
    long endtime = System.currentTimeMillis();
    System.out.println("For loop result:"+(endtime - starttime));
  }

  private static void printStreamData(int[] data) {
    long starttime = System.currentTimeMillis();
    Arrays.stream(data).forEach(System.out::print);
    long endtime = System.currentTimeMillis();
    System.out.println("Stream time result:"+(endtime - starttime));
  }

  private static void manupulateData(int[] data) {
    long starttime = System.currentTimeMillis();
    for (int i = 0; i < data.length; i++) {
      data[i]=data[i]+1;
      System.out.print(data[i]); // generate a random number
    }
    long endtime = System.currentTimeMillis();
    System.out.println("For loop manupulate result:"+(endtime - starttime));
  }

  private static void manupulateStreamData(int[] data) {
    long starttime = System.currentTimeMillis();
    Arrays.stream(data).map(x->x+1).forEach(System.out::print);
    long endtime = System.currentTimeMillis();
    System.out.println("Stream manupulate time result:"+(endtime - starttime));
  }



}
