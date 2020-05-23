package com.ka.rover.unit;

import com.ka.rover.exception.InvalidPlateauException;
import com.ka.rover.validator.PlateauValidator;
import org.junit.Test;

public class PlateauValidatorTest {

  @Test(expected = InvalidPlateauException.class)
  public void should_ThrowInvalidPlateauException_When_InputStringEmpty() {
    PlateauValidator.validateUpperRightCornerPosition("");
  }

  @Test(expected = InvalidPlateauException.class)
  public void should_ThrowInvalidPlateauException_When_InputStringIsNull() {
    PlateauValidator.validateUpperRightCornerPosition(null);
  }

  @Test(expected = InvalidPlateauException.class)
  public void should_ThrowInvalidPlateauException_When_InputStringHasMoreThanTwoCharacters() {
    PlateauValidator.validateUpperRightCornerPosition("3333");
  }

  @Test(expected = InvalidPlateauException.class)
  public void should_ThrowInvalidPlateauException_When_InputStringHasAlphanumericCharacters() {
    PlateauValidator.validateUpperRightCornerPosition("12N");
  }

}
