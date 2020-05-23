package com.ka.rover.unit;

import com.ka.rover.constant.Direction;
import com.ka.rover.core.RoverController;
import com.ka.rover.model.Plateau;
import com.ka.rover.model.Position;
import com.ka.rover.model.Rover;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoverControllerTest {

  private Plateau plateau;
  private Rover rover;
  private RoverController roverController;

  @Before
  public void beforeTest() {
    Position upperRightPosition = new Position(5, 5);
    Position roverPosition = new Position(1, 2);
    plateau = new Plateau(upperRightPosition);
    rover = new Rover(roverPosition, Direction.NORTH);
    roverController = new RoverController(rover, plateau);
  }

  @Test(expected = NullPointerException.class)
  public void should_ThrowNullpointerException_When_RoverIsEmpty() {
    new RoverController(null, plateau);
  }

  @Test(expected = NullPointerException.class)
  public void should_ThrowNullpointerException_When_PlateauIsEmpty() {
    new RoverController(rover, null);
  }

  @Test
  public void should_MoveToSouthProperly() {
    Position position = rover.getPosition();
    int previousYCoordinate = rover.getPosition().getCoordinateY();
    int previousXCoordinate = position.getCoordinateX();
    roverController.move("LLM");

    Assert.assertEquals(previousYCoordinate - 1, rover.getPosition().getCoordinateY());
    Assert.assertEquals(previousXCoordinate, position.getCoordinateX());
    Assert.assertEquals(Direction.SOUTH, rover.getDirection());
  }

  @Test
  public void should_MoveToNorthProperly() {
    Position position = rover.getPosition();
    int previousYCoordinate = position.getCoordinateY();
    int previousXCoordinate = position.getCoordinateX();
    roverController.move("RRRRMM");

    Assert.assertEquals(previousYCoordinate + 2, position.getCoordinateY());
    Assert.assertEquals(previousXCoordinate, position.getCoordinateX());
    Assert.assertEquals(Direction.NORTH, rover.getDirection());
  }

  @Test
  public void should_MoveToWestProperly() {
    Position position = rover.getPosition();
    int previousYCoordinate = rover.getPosition().getCoordinateY();
    int previousXCoordinate = position.getCoordinateX();
    roverController.move("LM");

    Assert.assertEquals(previousXCoordinate - 1, position.getCoordinateX());
    Assert.assertEquals(previousYCoordinate, position.getCoordinateY());
    Assert.assertEquals(Direction.WEST, rover.getDirection());
  }

  @Test
  public void should_MoveToEastProperly() {
    Position position = rover.getPosition();
    int previousYCoordinate = rover.getPosition().getCoordinateY();
    int previousXCoordinate = position.getCoordinateX();
    roverController.move("RM");

    Assert.assertEquals(previousXCoordinate + 1, position.getCoordinateX());
    Assert.assertEquals(previousYCoordinate, position.getCoordinateY());
    Assert.assertEquals(Direction.EAST, rover.getDirection());
  }

  @Test
  public void should_TurnOnly_WithoutMove() {
    Position position = rover.getPosition();
    int previousYCoordinate = rover.getPosition().getCoordinateY();
    int previousXCoordinate = position.getCoordinateX();
    roverController.move("RRRR");

    Assert.assertEquals(previousXCoordinate, position.getCoordinateX());
    Assert.assertEquals(previousYCoordinate, position.getCoordinateY());
    Assert.assertEquals(Direction.NORTH, rover.getDirection());
  }
}
