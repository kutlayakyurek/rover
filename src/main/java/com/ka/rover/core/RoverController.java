package com.ka.rover.core;

import com.ka.rover.constant.Direction;
import com.ka.rover.constant.Movement;
import com.ka.rover.exception.InvalidDirectionException;
import com.ka.rover.exception.UnknownMoveException;
import com.ka.rover.model.Plateau;
import com.ka.rover.model.Position;
import com.ka.rover.model.Rover;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class RoverController {

  @NonNull private Rover rover;
  @NonNull private final Plateau plateau;
  private LinkedList<Character> movements = new LinkedList<>();

  /**
   * Moves rover according to given inputs with FIFO manner.
   *
   * @param movementInstruction Given movement instruction text as string. Should be split out to
   *     get individual movement.
   */
  public void move(String movementInstruction) {
    movements.addAll(
        movementInstruction.chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

    movements.forEach(
        (movement) -> {
          char currentDirection = rover.getDirection();

          switch (currentDirection) {
            case Direction.NORTH:
              handleNorthDirection(movement);
              break;
            case Direction.SOUTH:
              handleSouthDirection(movement);
              break;
            case Direction.EAST:
              handleEastDirection(movement);
              break;
            case Direction.WEST:
              handleWestDirection(movement);
              break;
            default:
              throw new InvalidDirectionException(
                  "Invalid movement direction: " + currentDirection);
          }

          BoundValidator.validateBounds(plateau, rover.getPosition());
        });
  }

  private void handleNorthDirection(char movement) {
    switch (movement) {
      case Movement.MOVE:
        rover.moveToNorth();
        break;
      case Movement.RIGHT:
        rover.setDirection(Direction.EAST);
        break;
      case Movement.LEFT:
        rover.setDirection(Direction.WEST);
        break;
      default:
        throwUnknownMoveError(movement);
    }
  }

  private void handleSouthDirection(Character movement) {
    switch (movement) {
      case Movement.MOVE:
        rover.moveToSouth();
        break;
      case Movement.RIGHT:
        rover.setDirection(Direction.WEST);
        break;
      case Movement.LEFT:
        rover.setDirection(Direction.EAST);
        break;
      default:
        throwUnknownMoveError(movement);
    }
  }

  private void handleEastDirection(Character movement) {
    switch (movement) {
      case Movement.MOVE:
        rover.moveToEast();
        break;
      case Movement.RIGHT:
        rover.setDirection(Direction.SOUTH);
        break;
      case Movement.LEFT:
        rover.setDirection(Direction.NORTH);
        break;
      default:
        throwUnknownMoveError(movement);
    }
  }

  private void handleWestDirection(Character movement) {
    switch (movement) {
      case Movement.MOVE:
        rover.moveToWest();
        break;
      case Movement.RIGHT:
        rover.setDirection(Direction.NORTH);
        break;
      case Movement.LEFT:
        rover.setDirection(Direction.SOUTH);
        break;
      default:
        throwUnknownMoveError(movement);
    }
  }

  private void throwUnknownMoveError(char movement) {
    throw new UnknownMoveException("Invalid movement: " + movement);
  }

  @Override
  public String toString() {
    Position position = rover.getPosition();
    String roverStatus =
        "Rover: "
            + rover.getName()
            + "Position: "
            + position.getCoordinateX()
            + " "
            + position.getCoordinateY()
            + " "
            + rover.getDirection();

    return roverStatus;
  }
}
