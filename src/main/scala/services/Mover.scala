package services

import constants.Mappings
import models.Position

object Mover {

  private def isWithinRange(point: Int) = point >= 1 && point <= Mappings.BOARD_SIZE

  private def isPositionValid(currPosition: Position, newPosition: Position) =
    isWithinRange(newPosition.column) &&
      isWithinRange(newPosition.row) &&
      newPosition.column != currPosition.column &&
      newPosition.row != currPosition.row

  def moveHorizontalNSteps(position: Position, steps: Int): Seq[Position] =
    Range.inclusive(position.column - steps, position.column + steps)
      .collect { case column if isWithinRange(column) && column != position.column =>
        Position(column, position.row)
      }

  def moveVerticalNSteps(position: Position, steps: Int): Seq[Position] =
    Range.inclusive(position.row - steps, position.row + steps)
      .collect { case row if isWithinRange(row) && row != position.row =>
        Position(position.column, row)
      }

  def moveDiagonalNSteps(position: Position, steps: Int): Seq[Position] = {
    val diff = position.column - position.row
    Range.inclusive(position.column - steps, position.column + steps)
      .map(column => Position(column, column - diff))
      .filter(isPositionValid(position, _))
  }

  def moveSlantDiagonalNSteps(position: Position, steps: Int): Seq[Position] = {
    Range.inclusive(-steps, steps)
      .map(step => Position(position.column - step, position.row + step))
      .filter(isPositionValid(position, _))
  }

  def stringifyPosition(positions: Seq[Position]): String =
    positions
      .flatMap(pos => Mappings.INDEX_TO_COLUMN.get(pos.column).map(_ + pos.row))
      .mkString(", ")
}
