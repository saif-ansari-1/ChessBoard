package controller

import constants.PieceType
import models.{Piece, Position}
import services.Mover

class ChessController {

  def getQueenMoves(currentPosition: Position): String =
    Mover.stringifyPosition(
      Mover.moveDiagonalNSteps(currentPosition, 7) ++
        Mover.moveSlantDiagonalNSteps(currentPosition, 7) ++
        Mover.moveHorizontalNSteps(currentPosition, 7) ++
        Mover.moveVerticalNSteps(currentPosition, 7))

  def getPossibleMoves(piece: Piece): String = {
    piece.pieceType match {
      case PieceType.King => getKingMoves(piece.currentPosition)

      case PieceType.Horse => getHorseMoves(piece.currentPosition)

      case PieceType.Bishop => getBishopMoves(piece.currentPosition)

      case PieceType.Rook => getRookMoves(piece.currentPosition)

      case PieceType.Queen => getKingMoves(piece.currentPosition)

      case PieceType.Pawn => getPawnMoves(piece.currentPosition)

      case _ => "Invalid Piece value provided"
    }
  }

  def getKingMoves(currentPosition: Position): String =
    Mover.stringifyPosition(
      Mover.moveHorizontalNSteps(currentPosition, 1) ++
        Mover.moveVerticalNSteps(currentPosition, 1) ++
        Mover.moveDiagonalNSteps(currentPosition, 1) ++
        Mover.moveSlantDiagonalNSteps(currentPosition, 1))

  def getHorseMoves(currentPosition: Position): String = {
    val moveHorizontal2Times = Mover.moveHorizontalNSteps(currentPosition, 2)
    val moveVertical2Times = Mover.moveVerticalNSteps(currentPosition, 2)

    val possibleMoves =
      Seq(moveHorizontal2Times.head, moveHorizontal2Times.last)
        .flatMap { pos =>
          if (Math.abs(pos.column - currentPosition.column) == 2)
            Mover.moveVerticalNSteps(pos, 1)
          else Seq.empty
        } ++
        Seq(moveVertical2Times.head, moveVertical2Times.last)
          .flatMap { pos =>
            if (Math.abs(pos.row - currentPosition.row) == 2)
              Mover.moveHorizontalNSteps(pos, 1)
            else Seq.empty
          }
    Mover.stringifyPosition(possibleMoves)
  }

  def getBishopMoves(currentPosition: Position): String =
    Mover.stringifyPosition(
      Mover.moveDiagonalNSteps(currentPosition, 7) ++
        Mover.moveSlantDiagonalNSteps(currentPosition, 7))

  def getRookMoves(currentPosition: Position): String =
    Mover.stringifyPosition(
      Mover.moveHorizontalNSteps(currentPosition, 7) ++
        Mover.moveVerticalNSteps(currentPosition, 7))

  def getPawnMoves(currentPosition: Position): String =
    Mover.stringifyPosition(
      Seq(Mover.moveVerticalNSteps(currentPosition, 1).last,
        Mover.moveDiagonalNSteps(currentPosition, 1).last,
        Mover.moveSlantDiagonalNSteps(currentPosition, 1).last).filter(_.row - currentPosition.row == 1))
}
