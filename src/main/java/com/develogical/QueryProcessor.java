package com.develogical;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
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

    if(query.toLowerCase().contains("plus")) {

      Integer result = getDigitFromString(query).stream()
        .mapToInt(Integer::intValue).sum();

      return result.toString();
    }

    if(query.toLowerCase().contains("largest")) {
        OptionalInt result = getDigitFromString(query).stream()
          .mapToInt(Integer::intValue).max();

        return result.isPresent() ? result.toString() : "";
    }

    if(query.toLowerCase().contains("multiplied")) {
        Integer result = getDigitFromString(query)
          .stream().reduce(1, (a, b) -> a * b);

        return result.toString();
    }

    return "";
  }

  private List<Integer> getDigitFromString(String string) {
      List<String> words = List.of(string.split(" "));
      
      List<Integer> digits = words.stream()
        .map(s -> s.replaceAll("\\D+", ""))
        .filter(word -> !word.isBlank())
        .map(numberString -> Integer.valueOf(numberString))
        .collect(Collectors.toList());

        return digits;
  }
}
