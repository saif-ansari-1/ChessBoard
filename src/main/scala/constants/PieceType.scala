package constants

sealed  case class PieceType(name: String)

object PieceType {
  object King extends PieceType("King")
  object Queen extends PieceType("Queen")
  object Bishop extends PieceType("Bishop")
  object Horse extends PieceType("Horse")
  object Rook extends PieceType("Rook")
  object Pawn extends PieceType("Pawn")
}