package controller


import constants.PieceType
import models.{Piece, Position}
import org.scalatest.funspec.AnyFunSpec

class ChessControllerSpec extends AnyFunSpec {

  val chessController = new ChessController

  describe("getPossibleMoves with King") {

    it("should return 8 correct positions (4, 5)") {
     val piece =  Piece(PieceType.King, Position(4, 5))
      assert(chessController.getPossibleMoves(piece) == "C5, E5, D4, D6, C4, E6, E4, C6")
    }

    it("should return 3 correct positions from (1, 1)") {
      val piece =  Piece(PieceType.King, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) == "B1, A2, B2")
    }

    it("should return 3 correct positions from (8, 8)") {
      val piece =  Piece(PieceType.King, Position(8, 8))
      assert(chessController.getPossibleMoves(piece) == "G8, H7, G7")
    }

    it("should return 5 correct positions from (4, 1)") {
      val piece =  Piece(PieceType.King, Position(4, 1))
      assert(chessController.getPossibleMoves(piece) == "C1, E1, D2, E2, C2")
    }
  }



  describe("getPossibleMoves with Queen") {

    it("should return 21 correct positions (1, 1)") {
      val piece =  Piece(PieceType.Queen, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) ==
        "B2, C3, D4, E5, F6, G7, H8, B1, C1, D1, E1, F1, G1, H1, A2, A3, A4, A5, A6, A7, A8")
    }

    it("should return 27 correct positions from (4, 5)") {
      val piece =  Piece(PieceType.Queen, Position(4, 5))
      assert(chessController.getPossibleMoves(piece) ==
        "A2, B3, C4, E6, F7, G8, H1, G2, F3, E4, C6, B7, A8, A5, B5, C5, E5, F5, G5, H5, D1, D2, D3, D4, D6, D7, D8")
    }

    it("should return 3 correct positions from (4, 1)") {
      val piece =  Piece(PieceType.Queen, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) ==
        "B2, C3, D4, E5, F6, G7, H8, B1, C1, D1, E1, F1, G1, H1, A2, A3, A4, A5, A6, A7, A8")
    }

  }

  describe("getPossibleMoves with Bishop") {

    it("should return 7 correct positions from (1, 1)") {
      val piece =  Piece(PieceType.Bishop, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) == "B2, C3, D4, E5, F6, G7, H8")
    }

    it("should return 13 correct positions from (4, 5)") {
      val piece =  Piece(PieceType.Bishop, Position(4, 5))
      assert(chessController.getPossibleMoves(piece) == "A2, B3, C4, E6, F7, G8, H1, G2, F3, E4, C6, B7, A8")
    }

    it("should return 9 correct positions from (2, 2)") {
      val piece =  Piece(PieceType.Bishop, Position(2, 2))
      assert(chessController.getPossibleMoves(piece) == "A1, C3, D4, E5, F6, G7, H8, C1, A3")
    }
  }


  describe("getPossibleMoves with Horse") {

    it("should return 8 correct positions (5, 3)") {
      val piece =  Piece(PieceType.Horse, Position(5, 3))
      assert(chessController.getPossibleMoves(piece) == "C2, C4, G2, G4, D1, F1, D5, F5")
    }

    it("should return 2 correct positions from (1, 1)") {
      val piece =  Piece(PieceType.Horse, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) == "C2, B3")
    }

    it("should return 4 correct positions from (4, 1)") {
      val piece =  Piece(PieceType.Horse, Position(4, 1))
      assert(chessController.getPossibleMoves(piece) == "B2, F2, C3, E3")
    }

    it("should return 2 correct positions from (8, 8)") {
      val piece =  Piece(PieceType.Horse, Position(8, 8))
      assert(chessController.getPossibleMoves(piece) == "F7, G6")
    }
  }

  describe("getPossibleMoves with Rook") {

    it("should return 14 correct positions (1, 1)") {
      val piece =  Piece(PieceType.Rook, Position(1, 1))
      assert(chessController.getPossibleMoves(piece) ==
        "B1, C1, D1, E1, F1, G1, H1, A2, A3, A4, A5, A6, A7, A8")
    }

    it("should return 14 correct positions from (4, 5)") {
      val piece =  Piece(PieceType.Rook, Position(4, 5))
      assert(chessController.getPossibleMoves(piece) ==
        "A5, B5, C5, E5, F5, G5, H5, D1, D2, D3, D4, D6, D7, D8")
    }

    it("should return 14 correct positions from (8, 8)") {
      val piece =  Piece(PieceType.Rook, Position(8, 8))
      assert(chessController.getPossibleMoves(piece) ==
        "A8, B8, C8, D8, E8, F8, G8, H1, H2, H3, H4, H5, H6, H7")
    }
  }

  describe("getPossibleMoves with Pawn") {

    it("should return 0 positions (4, 8)") {
      val piece =  Piece(PieceType.Pawn, Position(4, 8))
      assert(chessController.getPossibleMoves(piece) == "")
    }

    it("should return 3 correct positions from (4, 2)") {
      val piece =  Piece(PieceType.Pawn, Position(4, 2))
      assert(chessController.getPossibleMoves(piece) == "D3, E3, C3")
    }

    it("should return 2 correct positions from (1, 2)") {
      val piece =  Piece(PieceType.Pawn, Position(1, 2))
      assert(chessController.getPossibleMoves(piece) == "A3, B3")
    }

    it("should return 2 correct positions from (8, 2)") {
      val piece =  Piece(PieceType.Pawn, Position(8, 2))
      assert(chessController.getPossibleMoves(piece) == "H3, G3")
    }
  }
}
