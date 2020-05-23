package com.ka.rover.core;

import com.ka.rover.exception.RoverException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHandler {

  /** Used for rover application exception handling. */
  public void handleException(RuntimeException exception) {
    if (exception instanceof RoverException) {
      log.error(exception.getMessage(), exception);
    } else {
      log.error("Unknown error occured", exception);
    }
  }
}
