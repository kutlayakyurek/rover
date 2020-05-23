package com.ka.rover.core;

import com.ka.rover.exception.OutOfBoundsException;
import com.ka.rover.model.Plateau;
import com.ka.rover.model.Position;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BoundValidator {

  /**
   * Validates rover position relatively to plateau bounds.
   *
   * @param plateau Given Plateau
   * @param position Given rover position
   */
  public static void validateBounds(Plateau plateau, Position position) {
    if (position.getCoordinateX() < plateau.getLowerLeftPosition().getCoordinateX()) {
      throw new OutOfBoundsException(
          "X coordinate of rover must be greater than plateau lower left X coordination");
    } else if (position.getCoordinateY() < plateau.getLowerLeftPosition().getCoordinateY()) {
      throw new OutOfBoundsException(
          "Y coordinate of rover must be greater than plateau lower left Y coordination");
    } else if (position.getCoordinateX() > plateau.getUpperRightPosition().getCoordinateX()) {
      throw new OutOfBoundsException(
          "X coordinate of rover must be lower than plateau upper right X coordination");
    } else if (position.getCoordinateY() > plateau.getUpperRightPosition().getCoordinateY()) {
      throw new OutOfBoundsException(
          "Y coordinate of rover must be lower than plateau upper right Y coordination");
    }
  }
}
