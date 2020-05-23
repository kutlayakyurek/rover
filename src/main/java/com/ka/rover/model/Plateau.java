package com.ka.rover.model;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Plateau {

  @Getter private final Position upperRightPosition;
  @Getter private final Position lowerLeftPosition;

  public Plateau(Position upperRightPosition) {
    this.lowerLeftPosition = new Position(0, 0);
    this.upperRightPosition = upperRightPosition;
  }
}
