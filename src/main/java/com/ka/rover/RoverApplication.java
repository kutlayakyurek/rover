package com.ka.rover;

import com.ka.rover.core.ExceptionHandler;
import com.ka.rover.core.RoverController;
import com.ka.rover.model.Plateau;
import com.ka.rover.model.Position;
import com.ka.rover.model.Rover;
import com.ka.rover.validator.BoundValidator;
import com.ka.rover.validator.MovementValidator;
import com.ka.rover.validator.PlateauValidator;
import com.ka.rover.validator.RoverValidator;

import java.util.Scanner;

public class RoverApplication {

  /**
   * Rover application simply asks for upper right coordination of the plateau. Then it asks for
   * first and second rovers position and movement instructions sequentially. Finally application
   * prints out final positions of the rovers.
   */
  public RoverApplication() throws RuntimeException {
    Scanner scanner = new Scanner(System.in);

    // Get upper right coordinate of the plateau
    System.out.println("-----Enter upper right coordinate of the plateau-----");
    String upperRightCoordinateInput = scanner.nextLine();
    PlateauValidator.validateUpperRightCornerPosition(upperRightCoordinateInput);

    // Initialize plateau assuming that 0,0 is lower left coordinate
    Position upperRightPosition =
        new Position(upperRightCoordinateInput.charAt(0), upperRightCoordinateInput.charAt(1));
    Plateau plateau = new Plateau(upperRightPosition);

    // Initialize first rover
    System.out.println("-----Enter first rover position-----");
    Rover firstRover = initializeRover(plateau, scanner.nextLine());
    firstRover.setName("First");
    final RoverController firstRoverController = new RoverController(firstRover, plateau);

    // Move first rover
    System.out.println("-----Enter first rover movement instruction-----");
    String movementInput = scanner.nextLine();
    MovementValidator.validateRoverMovement(movementInput);
    firstRoverController.move(movementInput);

    // Initialize second rover
    System.out.println("-----Enter second rover position-----");
    Rover secondRover = initializeRover(plateau, scanner.nextLine());
    secondRover.setName("Second");
    final RoverController secondRoverController = new RoverController(secondRover, plateau);

    // Move second rover
    System.out.println("-----Enter second rover movement instruction-----");
    movementInput = scanner.nextLine();
    MovementValidator.validateRoverMovement(movementInput);
    secondRoverController.move(movementInput);

    // Output results
    System.out.println();
    System.out.println("-----RESULTS-----");
    System.out.println(firstRoverController.toString());
    System.out.println("------------------------------");
    System.out.println(secondRoverController.toString());
  }

  private Rover initializeRover(Plateau plateau, String roverPositionInput) {
    RoverValidator.validateRoverPosition(roverPositionInput);
    Position firstRoverPosition =
        new Position(roverPositionInput.charAt(0), roverPositionInput.charAt(1));
    BoundValidator.validateBounds(plateau, firstRoverPosition);
    return new Rover(firstRoverPosition, roverPositionInput.charAt(2));
  }

  /** Application starts here. */
  public static void main(String[] args) {
    try {
      new RoverApplication();
    } catch (RuntimeException ex) {
      // AOP could be integrated
      ExceptionHandler exceptionHandler = new ExceptionHandler();
      exceptionHandler.handleException(ex);
    }
  }
}
