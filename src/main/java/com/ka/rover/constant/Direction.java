package com.ka.rover.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Direction {

  public static final char NORTH = 'N';
  public static final char SOUTH = 'S';
  public static final char WEST = 'W';
  public static final char EAST = 'E';

  public static boolean isValidDirection(char direction) {
    return direction == NORTH || direction == SOUTH || direction == WEST || direction == EAST;
  }
}
