package com.ka.rover.validator;

import com.ka.rover.exception.InvalidPlateauException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlateauValidator {

  /**
   * Validates upper right coordinates of the plateau.
   *
   * <p>Checks if input string is empty.
   *
   * <p>Checks if input string has two characters.
   *
   * <p>Checks if input string has empty characters.
   *
   * <p>Checks if input string has alphanumeric characters.
   *
   * @param position X-Y coordinates of plateau
   */
  public static void validateUpperRightCornerPosition(String position) {
    if (position == null || position.isEmpty()) {
      throw new InvalidPlateauException("Upper right coordinates are empty");
    }

    if (position.length() != 2) {
      throw new InvalidPlateauException("Upper right coordinates length must be two.");
    }

    position
        .chars()
        .filter(c -> c == ' ')
        .findAny()
        .ifPresent(
            c -> {
              throw new InvalidPlateauException(
                  "Upper right coordinates must not contain empty characters.");
            });

    position
        .chars()
        .filter(c -> Character.isLetter(c))
        .findAny()
        .ifPresent(
            c -> {
              throw new InvalidPlateauException(
                  "Upper right coordinates must only contain digits.");
            });
  }
}
