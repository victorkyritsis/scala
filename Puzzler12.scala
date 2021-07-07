case class RomanNumeral(symbol: String, value: Int)

implicit object RomanOrdering extends Ordering[RomanNumeral] {
  def compare(a: RomanNumeral, b: RomanNumeral) = {
    a.value compare b.value
  }
}

import collection.immutable.SortedSet

val numerals = SortedSet(
  RomanNumeral("M", 1000), RomanNumeral("C", 100),  RomanNumeral("X", 10),
  RomanNumeral("I", 1), RomanNumeral("D", 500), RomanNumeral("L", 50),
  RomanNumeral("V", 5)
)

// numerals.toSeq map {_.symbol} foreach {println(_)}


for(num <- numerals; sym <- num.symbol) {
  print(s"${sym} ")
}
