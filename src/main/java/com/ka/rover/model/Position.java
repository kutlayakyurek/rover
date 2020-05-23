package com.ka.rover.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {

  private int coordinateX;
  private int coordinateY;

  public Position(char coordinateX, char coordinateY) {
    this.coordinateX = Character.getNumericValue(coordinateX);
    this.coordinateY = Character.getNumericValue(coordinateY);
  }
}
