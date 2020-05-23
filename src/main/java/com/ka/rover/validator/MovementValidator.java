package com.ka.rover.validator;

import com.ka.rover.constant.Direction;
import com.ka.rover.constant.Movement;
import com.ka.rover.exception.InvalidMoveException;
import com.ka.rover.exception.InvalidRoverPositionException;
import com.ka.rover.util.StringUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovementValidator {

  /**
   * Validates rover movement instruction
   *
   * <p>Checks if input string is empty.
   *
   * <p>Checks if input string has empty characters.
   *
   * <p>Checks if input string has only L(LEFT)-M(MOVE)-R(RIGHT)
   *
   * @param movement Movement instruction input of the rover
   */
  public static void validateRoverMovement(String movement) {
    if (movement == null || movement.isEmpty()) {
      throw new InvalidMoveException("Rover movement input is empty");
    }

    if (StringUtils.doesStringContainEmptyChars(movement)) {
      throw new InvalidMoveException(
          "Rover movement instruction must not contain empty characters");
    }

    if (!Movement.isValidMove(movement)) {
      throw new InvalidMoveException("Movement instruction must only contain M-L-R");
    }
  }
}
