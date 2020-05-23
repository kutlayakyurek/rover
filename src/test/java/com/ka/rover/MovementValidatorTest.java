package com.ka.rover;

import com.ka.rover.exception.InvalidMoveException;
import com.ka.rover.validator.MovementValidator;
import org.junit.Test;

public class MovementValidatorTest {

  @Test(expected = InvalidMoveException.class)
  public void should_ThrowInvalidMoveException_When_InputStringEmpty() {
    MovementValidator.validateRoverMovement("");
  }

  @Test(expected = InvalidMoveException.class)
  public void should_ThrowInvalidMoveException_When_InputStringIsNull() {
    MovementValidator.validateRoverMovement(null);
  }

  @Test(expected = InvalidMoveException.class)
  public void should_ThrowInvalidMoveException_When_InputStringIsInvalid() {
    MovementValidator.validateRoverMovement("ABC");
  }
}
