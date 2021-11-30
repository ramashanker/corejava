package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordMatching {
  public static void main(String[] args) {
    String input = "mouse";
    List<String> repository = Arrays.asList("Mouse", "Monitor", "Mousepad", "Mouseboard", "MutherBoard");
    List<List<String>> result = searchSuggestion(repository, input);
    System.out.println(result);
  }

  private static List<List<String>> searchSuggestion(List<String> repository, String key) {
    List<List<String>> suggestion = new ArrayList<>();
    for (int i = 1; i <= key.length(); i++) {
      int j = 0;
      String query = key.substring(j, i).toLowerCase();
      List<String> matchingString = repository.stream().map(str -> str.toLowerCase()).filter(str -> str.contains(query)).collect(Collectors.toList());
      System.out.println(query + "::" + matchingString);
      if (matchingString.size() > 0) {
        suggestion.add(matchingString);
      }
    }
    return suggestion;

  }
}
