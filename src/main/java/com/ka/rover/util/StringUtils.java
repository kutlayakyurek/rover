package com.ka.rover.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

  public static boolean doesStringContainEmptyChars(String input) {
    return input.chars().filter(c -> c == ' ').findAny().isPresent();
  }
}
