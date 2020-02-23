package services

import models.Position
import org.scalatest.funspec.AnyFunSpec

class MoverSpec extends AnyFunSpec {

  describe("moveHorizontalNSteps") {

    it("should return one position") {
      val currPosition = Position(1, 1)
      val result = Mover.moveHorizontalNSteps(currPosition, 1)

      assert(result.size == 1)
      assert(result.forall(_.row == 1))
      assert(result.forall(_.column == 2))
    }

    it("should return 7 positions") {
      val currPosition = Position(4, 1)
      val result = Mover.moveHorizontalNSteps(currPosition, 7)

      assert(result.size == 7)
      assert(result.forall(_.row == 1))
      assert(result.map(_.column) == Seq(1, 2, 3, 5, 6, 7, 8))
    }
  }

  describe("moveVerticalNSteps") {

    it("should return one position") {
      val currPosition = Position(1, 1)
      val result = Mover.moveVerticalNSteps(currPosition, 1)

      assert(result.size == 1)
      assert(result.forall(_.row == 2))
      assert(result.forall(_.column == 1))
    }

    it("should return 7 positions") {
      val currPosition = Position(4, 4)
      val result = Mover.moveVerticalNSteps(currPosition, 7)

      assert(result.size == 7)
      assert(result.forall(_.column == 4))
      assert(result.map(_.row) == Seq(1, 2, 3, 5, 6, 7, 8))
    }
  }

  describe("moveDiagonalNSteps") {

    it("should return empty") {
      val currPosition = Position(8, 1)
      val result = Mover.moveDiagonalNSteps(currPosition, 1)

      assert(result.isEmpty)
    }

    it("should return one position") {
      val currPosition = Position(4, 1)
      val result = Mover.moveDiagonalNSteps(currPosition, 1)

      assert(result.size == 1)
      assert(result.forall(_.row == 2))
      assert(result.forall(_.column == 5))
    }

    it("should return 7 positions") {
      val currPosition = Position(4, 4)
      val result = Mover.moveDiagonalNSteps(currPosition, 7)

      assert(result.size == 7)
      assert(result.map(_.column) == Seq(1, 2, 3, 5, 6, 7, 8))
      assert(result.map(_.row) == Seq(1, 2, 3, 5, 6, 7, 8))
    }
  }

  describe("moveSlantDiagonalNSteps") {

    it("should return empty") {
      val currPosition = Position(1, 1)
      val result = Mover.moveSlantDiagonalNSteps(currPosition, 1)

      assert(result.isEmpty)
    }

    it("should return one position") {
      val currPosition = Position(4, 1)
      val result = Mover.moveSlantDiagonalNSteps(currPosition, 1)

      assert(result.size == 1)
      assert(result.forall(_.row == 2))
      assert(result.forall(_.column == 3))
    }

    it("should return 7 positions") {
      val currPosition = Position(4, 4)
      val result = Mover.moveSlantDiagonalNSteps(currPosition, 7)

      assert(result.size == 6)
      assert(result.map(_.column) == Seq(7, 6, 5, 3, 2, 1))
      assert(result.map(_.row) == Seq(1, 2, 3, 5, 6, 7))
    }
  }

  describe("stringifyPosition") {
    it("should return string of positions") {
      assert(Mover.stringifyPosition(Seq(Position(1, 1), Position(2, 2), Position(3, 3))) == "A1, B2, C3")
    }

    it("should return empty string") {
      assert(Mover.stringifyPosition(Seq.empty) == "")
    }
  }
}
