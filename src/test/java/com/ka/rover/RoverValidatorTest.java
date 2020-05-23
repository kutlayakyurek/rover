package com.ka.rover;

import com.ka.rover.exception.InvalidRoverPositionException;
import com.ka.rover.validator.RoverValidator;
import org.junit.Test;

public class RoverValidatorTest {

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_InputIsEmpty() {
    RoverValidator.validateRoverPosition("");
  }

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_InputIsNull() {
    RoverValidator.validateRoverPosition(null);
  }

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_InputLengthIsNotCorrect() {
    RoverValidator.validateRoverPosition("ABEACSASD");
  }

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_FirstTwoCharactersAreNonDigits() {
    RoverValidator.validateRoverPosition("ABE");
  }

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_LastCharacterIsNotValid() {
    RoverValidator.validateRoverPosition("A");
  }

  @Test(expected = InvalidRoverPositionException.class)
  public void should_ThrowInvalidRoverPositionException_When_LastCharacterIsDigit() {
    RoverValidator.validateRoverPosition("123");
  }

}
