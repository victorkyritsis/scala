class Queue[T] private (
    private val leading: List[T],
    private val trailing: List[T]
) {
  private def mirror =
    if(leading.isEmpty)
      new Queue[T](trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) =
    new Queue(leading, x::trailing)

  // def this() = this(Nil, Nil)

  //def this(elems: T*) = this(elems.toList, Nil)
}

object Queue {
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}

// The last parameter to a functiobn may be repeated
def echo(args: String*) =
  for(arg <- args) println(arg)
