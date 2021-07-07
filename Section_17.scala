import scala.collection.mutable

def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]

  for(rawWord <- text.split("[ ,!.]+")) {
    val word = rawWord.toLowerCase

    val oldCount =
      if(counts.contains(word)) counts(word)
      else 0

    counts += (word -> (oldCount + 1))
  }
  counts
}

def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0

  for(i <- 1 until words.length) {
    if(words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  }
  (word, idx)
}


countWords("See Spot run! Run, Spot. Run!")
