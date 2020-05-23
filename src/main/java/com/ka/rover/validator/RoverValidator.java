package com.ka.rover.validator;

import com.ka.rover.constant.Direction;
import com.ka.rover.exception.InvalidRoverPositionException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RoverValidator {

  /**
   * Validates coordinates of the rover.
   *
   * <p>Checks if input string is empty.
   *
   * <p>Checks if input string has three characters.
   *
   * <p>Checks if input string has empty characters.
   *
   * <p>Checks if input string has two digits as prefix and valid direction character as postfix
   *
   * @param position X-Y coordinates of plateau
   */
  public static void validateRoverPosition(String position) {
    if (position == null || position.isEmpty()) {
      throw new InvalidRoverPositionException("Rover position is empty");
    }

    if (position.length() != 3) {
      throw new InvalidRoverPositionException("Rover position length must be three");
    }

    position
        .chars()
        .filter(c -> c == ' ')
        .findAny()
        .ifPresent(
            c -> {
              throw new InvalidRoverPositionException(
                  "Rover position must not contain empty characters");
            });

    char[] chars = position.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      char positionChar = chars[i];

      if ((i == 0 || i == 1) && Character.isLetter(positionChar)) {
        throw new InvalidRoverPositionException(
            "First two characters of rover position must be "
                + "digit resembling x-y coordinates of the rover");
      } else if (i == 2 && !Direction.isValidDirection(positionChar)) {
        throw new InvalidRoverPositionException(
            "Last digit of rover position must be one of the characters -> N,S,W,E");
      }
    }
  }
}
