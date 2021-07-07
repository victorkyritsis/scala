class SlowAppendQueue[T](elems: List[T]) {
  def head = elems.head

  def tail = new SlowAppendQueue(elems.tail)

  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}

class SlowHeadQueue[T](smele: List[T]) {
  def head = smele.last

  def tail = new SlowHeadQueue(smele.init)

  def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}

// Hiding the primary constructor by adding a private modifier
// in front of the parameter list/
// The primary constructor can be accessed only from within
// the class itself and its companion object
class Queue[T] private (
  private val leading: List[T],
  private val trailing: List[T]
) {

  private def mirror =
    if(leading.isEmpty) {
      //The mirror has to reverse-copy a list of length n
      new Queue(trailing.reverse, Nil)
    } else
      this

    def head = mirror.leading.head

    def enqueue(x: T) = new Queue(leading, x::trailing)

    def tail = {
      val q = mirror
      new Queue(q.leading.tail, q.trailing)
    }
}

//* is the notation for the repeated parameters
object Queue {
  def apply[T](xs: T*) {
    new Queue[T](xs.toList, Nil)
  }
}
