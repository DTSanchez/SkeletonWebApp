package com.develogical;

import java.util.List;
import java.util.stream.Collectors;

public class QueryProcessor {

  public String process(String query) {

    System.out.println("Received query:" + query);

    if (query.toLowerCase().contains("shakespeare")) {
      return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
          + "English poet, playwright, and actor, widely regarded as the greatest "
          + "writer in the English language and the world's pre-eminent dramatist.";
    }

    if(query.toLowerCase().contains("what is your name?")) {
      return "My name is Diego";
    }

    if(query.toLowerCase().startsWith("what is ")) {

      //query = query.replaceAll(",", "").replaceAll("?", "");
      //query = query.replaceAll("\\D+", "");

      List<String> words = List.of(query.split(" "));
      
      List<Integer> digits = words.stream()
        .map(s -> s.replaceAll("\\D+", ""))
        .filter(word -> !word.isBlank())
        .map(numberString -> Integer.valueOf(numberString))
        .collect(Collectors.toList());

      Integer result = digits.stream().mapToInt(Integer::intValue).sum();
      return result.toString();
    }

    if(query.toLowerCase().startsWith("which of the following numbers is the largest: ")) {

    }

    return "";
  }
}
