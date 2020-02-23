package constants

import scala.collection.immutable.HashMap

object Mappings {

    val BOARD_SIZE = 8

    val COLUMN_TO_INDEX: HashMap[String, Int] =
    HashMap(
      "A" -> 1,
      "B" -> 2,
      "C" -> 3,
      "D" -> 4,
      "E" -> 5,
      "F" -> 6,
      "G" -> 7,
      "H" -> 8)

  val INDEX_TO_COLUMN: HashMap[Int, String] =
    HashMap(1 -> "A",
      2 -> "B",
      3 -> "C",
      4 -> "D",
      5 -> "E",
      6 -> "F",
      7 -> "G",
      8 -> "H")
}
