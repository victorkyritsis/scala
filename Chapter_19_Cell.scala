class Cell[T](init: T) {
  private [this] var current = init

  def get = current

  def set(x: T) = {current = x}
}

class Queue[+T] (private val leading: List[T],
                private val trailing: List[T]) {
        def enqueue[U >: T](x: U) = new Queue[U](leading, x :: trailing);
}

// OutputChannel is defined to be contravariant in T.
// So an output channel of AnyRefs is a subtype of an output channel of Strings
trait OutputChannel[-T] {
  def write(x: T)
}

class Publication(val title: String)

class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )

  def printBookList(info: Book => AnyRef) = {
    for(book <- books) println(info(book))
  }
}

object Customer {
  def getTitle(p: Publication): String = p.title

  Library.printBookList(getTitle)
}
