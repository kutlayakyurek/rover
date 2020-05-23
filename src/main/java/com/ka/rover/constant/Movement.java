package com.ka.rover.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Movement {

  public static final char MOVE = 'M';
  public static final char LEFT = 'L';
  public static final char RIGHT = 'R';

  /**
   * Checks if movement instruction has only valid characters.
   *
   * @param movement Movement instruction as string such as "LMLMMM"
   * @return If movement instruction is valid
   */
  public static boolean isValidMove(String movement) {
    char[] movementChars = movement.toCharArray();

    for (char move : movementChars) {
      if (move != MOVE && move != LEFT && move != RIGHT) {
        return false;
      }
    }
    return true;
  }
}
