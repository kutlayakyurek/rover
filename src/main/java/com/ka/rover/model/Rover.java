package com.ka.rover.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Rover {

  private String name = "Unknown Rover";

  @NonNull private Position position;

  @NonNull private char direction;

  public void moveToNorth() {
    position.setCoordinateY(position.getCoordinateY() + 1);
  }

  public void moveToSouth() {
    position.setCoordinateY(position.getCoordinateY() - 1);
  }

  public void moveToEast() {
    position.setCoordinateX(position.getCoordinateX() + 1);
  }

  public void moveToWest() {
    position.setCoordinateX(position.getCoordinateX() - 1);
  }

}
