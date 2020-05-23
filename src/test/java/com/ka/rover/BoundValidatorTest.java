package com.ka.rover;

import com.ka.rover.constant.Direction;
import com.ka.rover.core.RoverController;
import com.ka.rover.exception.OutOfBoundsException;
import com.ka.rover.model.Plateau;
import com.ka.rover.model.Position;
import com.ka.rover.model.Rover;
import org.junit.Test;

public class BoundValidatorTest {

    @Test(expected = OutOfBoundsException.class)
    public void should_ThrowOutOfBoundsException_When_RoverMovesOutOf_LowerLeftXPosition() {
        Position upperRightPosition = new Position(5, 5);
        Position roverPosition = new Position(4, 4);
        Plateau plateau = new Plateau(upperRightPosition);
        Rover rover = new Rover(roverPosition, Direction.NORTH);
        RoverController roverController = new RoverController(rover, plateau);

        roverController.move("LMMMMM");
    }

    @Test(expected = OutOfBoundsException.class)
    public void should_ThrowOutOfBoundsException_When_RoverMovesOutOf_LowerLeftYPosition() {
        Position upperRightPosition = new Position(5, 5);
        Position roverPosition = new Position(4, 4);
        Plateau plateau = new Plateau(upperRightPosition);
        Rover rover = new Rover(roverPosition, Direction.NORTH);
        RoverController roverController = new RoverController(rover, plateau);

        roverController.move("LLMMMMM");
    }

    @Test(expected = OutOfBoundsException.class)
    public void should_ThrowOutOfBoundsException_When_RoverMovesOutOf_UpperRightXPosition() {
        Position upperRightPosition = new Position(5, 5);
        Position roverPosition = new Position(4, 4);
        Plateau plateau = new Plateau(upperRightPosition);
        Rover rover = new Rover(roverPosition, Direction.NORTH);
        RoverController roverController = new RoverController(rover, plateau);

        roverController.move("RMM");
    }

    @Test(expected = OutOfBoundsException.class)
    public void should_ThrowOutOfBoundsException_When_RoverMovesOutOf_UpperRightYPosition() {
        Position upperRightPosition = new Position(5, 5);
        Position roverPosition = new Position(4, 4);
        Plateau plateau = new Plateau(upperRightPosition);
        Rover rover = new Rover(roverPosition, Direction.NORTH);
        RoverController roverController = new RoverController(rover, plateau);

        roverController.move("MM");
    }
}
