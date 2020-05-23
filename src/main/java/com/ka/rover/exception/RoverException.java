package com.ka.rover.exception;

public class RoverException extends RuntimeException {

  private RoverException() {}

  public RoverException(String message) {
    super(message);
  }
}
