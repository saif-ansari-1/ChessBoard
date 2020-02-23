import constants.{Mappings, PieceType}
import controller.ChessController
import models.{Piece, Position}

object ChessBoardDriver {

  def main(args: Array[String]): Unit = {
    parsePosition(args(1)) match {
      case Some(position) =>
        val chessController = new ChessController
        val piece: Piece = Piece(PieceType(args(0)), position)
        println(chessController.getPossibleMoves(piece))
      case _ => println("Invalid Position provided")
    }
  }

  private def parsePosition(input: String): Option[Position] = {
    val tokens = input.split("")
    if (tokens.size == 2) {
      Mappings.COLUMN_TO_INDEX
        .get(tokens.head)
        .flatMap(column => {
          val row = Integer.parseInt(tokens.last)
          if (row >= 1 && row <= Mappings.BOARD_SIZE) Some(Position(column, row)) else None
        })
    } else None
  }
}

