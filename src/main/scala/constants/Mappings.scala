package constants

import scala.collection.immutable.HashMap

object Mappings {

    val BOARD_SIZE = 8

    val columnToIndex: HashMap[String, Int] =
    HashMap(
      "A" -> 1,
      "B" -> 2,
      "C" -> 3,
      "D" -> 4,
      "E" -> 5,
      "F" -> 6,
      "G" -> 7,
      "H" -> 8)

  val indexToColumn: HashMap[Int, String] =
    HashMap(1 -> "A",
      2 -> "B",
      3 -> "C",
      4 -> "D",
      5 -> "E",
      6 -> "F",
      7 -> "G",
      8 -> "H")
}
