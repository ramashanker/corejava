package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

  /*
   * Complete the 'searchSuggestions' function below.
   *
   * The function is expected to return a 2D_STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY repository
   *  2. STRING customerQuery
   */

  public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
    // Write your code here

    List<List<String>> suggestion = new ArrayList<>();

    repository.forEach(data-> {
      if(isMatched(customerQuery,String.valueOf(data))){
        suggestion.add(Arrays.asList(String.valueOf(data)));
      }
    });
    return suggestion;
  }

  private static boolean isMatched(String query,String text){
    return text.toLowerCase().contains(query.toLowerCase());
  }

}
