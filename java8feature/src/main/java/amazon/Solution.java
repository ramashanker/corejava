package amazon;

import java.io.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  //List<String> repository=new ArrayList<>(Arrays.asList("mobile","mouse","moneypot","monoitor"));
  //String customeQuery="mo";



  public static void main(String[] args) throws IOException {
    /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int repositoryCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> repository = new ArrayList<>();

    for (int i = 0; i < repositoryCount; i++) {
      String repositoryItem = bufferedReader.readLine();
      repository.add(repositoryItem);
    }

    String customerQuery = bufferedReader.readLine();*/
    List<String> repository=new ArrayList<>(Arrays.asList("mobile","mouse","moneypot","monoitor"));
    String customeQuery="mou";


    List<List<String>> result = Result.searchSuggestions(repository, customeQuery);
    System.out.println(result);

    /*for (int i = 0; i < result.size(); i++) {
      for (int j = 0; j < result.get(i).size(); j++) {
        bufferedWriter.write(result.get(i).get(j));

        if (j != result.get(i).size() - 1) {
          bufferedWriter.write(" ");
        }
      }

      if (i != result.size() - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();*/
  }
}
